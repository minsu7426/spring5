package gg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.google.gson.JsonArray;

public class Jido_test2 {

	public static void main(String[] args){

		String address = "창원시 의창구 서상동 699-10";
		// Geocoding의 id과 secret값 (https://console.ncloud.com/naver-service/application)
		String clientId = "n7yw3r4itk";
		String clientSecret = "OYDtkMjlCarMUu11SFE3b0VIEPgi6LjiOvXatZCI";
		
		try {
			//주소를 URL에 적용하기 위한 type(ascii코드?)로 변경한다.
			String addr = URLEncoder.encode(address, "UTF-8");
			
			//Geocoding의 요청 API URL을 주소와 같이 넣어준다.
			String apiURL = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=" + addr;
			
			//URL 주소를 담기위해 URL 클래스를 생성한다.
			URL url = new URL(apiURL);
			
			//외부 서버와 url을 연결하기위해 HttpURLConnection을 생성한다.
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			//API의 메서드를 가져오기 위한 GET
			con.setRequestMethod("GET");
			
			//API의 요청 헤더값을 입력해준다.
			con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
			con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);

			//요청 결과를 확인한다. 정상 호출인경우 200을 반환
			int responseCode = con.getResponseCode();

			BufferedReader br;
			
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}

			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			
			br.close();
			
			JSONTokener tokener = new JSONTokener(response.toString());
			JSONObject object = new JSONObject(tokener);			
			JSONArray arr = object.getJSONArray("addresses");
			
			for (int i = 0; i < arr.length(); i++) {
				JSONObject temp = (JSONObject) arr.get(i);
				System.out.println("도로명 : " + temp.get("roadAddress"));
				System.out.println("지번 : " + temp.get("jibunAddress"));
				System.out.println("위도 : " + temp.get("y"));
				System.out.println("경도 : " + temp.get("x"));
			}
			
		} catch (Exception ex) {
			System.out.println("에러 : "+ex);
		}
	}

}
