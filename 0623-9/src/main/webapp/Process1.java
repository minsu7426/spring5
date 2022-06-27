package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Juso {

	HttpServletRequest request;

	String map = request.getParameter("map");

	System.out.println(map);

	String address = "창원시 의창구 서상동 699-10";
	// Geocoding의 id과 secret값 (https://console.ncloud.com/naver-service/application)
	String id = "n7yw3r4itk";
	String secret = "OYDtkMjlCarMUu11SFE3b0VIEPgi6LjiOvXatZCI";

	try
	{
		// 주소를 URL에 적용하기 위한 type(ascii코드?)로 변경한다.
		String addr = URLEncoder.encode(address, "UTF-8");
		// Geocoding의 요청 API URL을 주소와 같이 넣어준다.
		String apiURL = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=" + addr;
		// URL 주소를 담기위해 URL 클래스를 생성한다.
		URL url = new URL(apiURL);
		// 외부 서버와 url을 연결하기위해 HttpURLConnection을 생성한다.
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		// API의 메서드를 가져오기 위한 GET
		con.setRequestMethod("GET");
		// API의 요청 헤더값을 입력해준다.
		con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", id);
		con.setRequestProperty("X-NCP-APIGW-API-KEY", secret);

		// 요청 결과를 확인한다. 정상 호출인경우 200을 반환
		int responseCode = con.getResponseCode();

		// API의 반환받은 값을 BufferedReader에 담는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

		String inputLine;

		StringBuffer response = new StringBuffer();

		// inputLine과 response는 같다
//			inputLine = br.readLine();
//			response.append(inputLine);
		while ((inputLine = br.readLine()) != null) {

			response.append(inputLine);
		}

		// 사용한 버퍼를 close한다.
		br.close();

		// 읽어온 JSON 데이터를 메모리에 담는다.
		JSONTokener tokner = new JSONTokener(response.toString());
		// JSON객체를 생성한다.
		JSONObject object = new JSONObject(tokner);
		// 객체에 담겨져있는 jsonArray의 "addresses" Array을 담는다.
		JSONArray arr = object.getJSONArray("addresses");

		double[] juso = new double[2];

		for (int i = 0; i < arr.length(); i++) {
			// JSON객체를 생성하여 JSONArray에 담겨진 값을 casting하여 담는다.
			JSONObject tmp = (JSONObject) arr.get(i);
			// 담겨진 값의 "roadAddress"라는 key를 가진 value를 출력한다.
			System.out.println("도로명 주소 : " + tmp.get("roadAddress"));
			System.out.println("지번 주소 : " + tmp.get("jibunAddress"));
			System.out.println("위도 : " + tmp.get("y"));
			System.out.println("경도 : " + tmp.get("x"));
			juso[0] = tmp.getDouble("y");
			juso[1] = tmp.getDouble("x");
		}
		System.out.println(juso.toString());

	}catch(IOException ex){
		System.out.println("에러" + ex);
	}
	RequestDispatcher rd = request.getRequestDispatcher("/search.jsp");
	rd.forward(request, response);	
}
