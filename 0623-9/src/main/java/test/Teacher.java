package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Teacher {

	Map<String, String> result = Teacher.getGeoDataByAddress("창원시 의창구 서상동 699-10");

	private static Map<String, String> getGeoDataByAddress(String completeAddress) {
		try {
			// 사용자 인증을하는 KEY값
			String API_KEY = "AIzaSyDXMN6Lg3WVVzi20NcbAEEBJu6Xw9Ai3Cs";
			// 요청 API URL에 주소를 URL에 적용하기 위한 type으로 변경하고, KEY값을 같이 넣어준다.
			String surl = "https://maps.googleapis.com/maps/api/geocode/json?address="
					+ URLEncoder.encode(completeAddress, "UTF-8") + "&key=" + API_KEY;
			// URL 주소를 담기 위해 URL 클래스를 생성한다.
			URL url = new URL(surl);
			
			
			InputStream is = url.openConnection().getInputStream();

			// BufferedReader 객체에 연결한 API의 반환 값을 담아준다.
			BufferedReader streamReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

			StringBuilder responseStrBuilder = new StringBuilder();
			String inputStr;
			System.out.println(">>>>>>>>>> >>>>>>>>>> InputStream Start <<<<<<<<<< <<<<<<<<<<");
			// Inputstr에 담긴 값을 읽어와서 출력한다. JSON안에 뭐가 담겨잇는지 출력
			while ((inputStr = streamReader.readLine()) != null) {
				System.out.println(">>>>>>>>>>     " + inputStr);
				responseStrBuilder.append(inputStr);
			}
			System.out.println(">>>>>>>>>> >>>>>>>>>> InputStream End <<<<<<<<<< <<<<<<<<<<");

			// JSON객체를 생성하여 responseStrBuilder에 담긴 JSON 값을 넣어준다.
			JSONObject jo = new JSONObject(responseStrBuilder.toString());
			
			// 객체에 담겨져있는 JSONArray의 "results" KEY값을 담는다.
			JSONArray results = jo.getJSONArray("results");
			String region = null;
			String province = null;
			String zip = null;
			
			// MAP ret는 json에서 geometry location lat을 가져와서 double lat에 담는다.
			
			Map<String, String> ret = new HashMap<String, String>();
			
			if (results.length() > 0) {
				JSONObject jsonObject;
				jsonObject = results.getJSONObject(0);
				Double lat = jsonObject.getJSONObject("geometry").getJSONObject("location").getDouble("lat");
				Double lng = jsonObject.getJSONObject("geometry").getJSONObject("location").getDouble("lng");
				ret.put("lat", lat.toString());
				ret.put("lng", lng.toString());
				System.out.println("LAT:\t\t" + lat);
				System.out.println("LNG:\t\t" + lng);
				JSONArray ja = jsonObject.getJSONArray("address_components");
				for (int l = 0; l < ja.length(); l++) {
					JSONObject curjo = ja.getJSONObject(l);
					String type = curjo.getJSONArray("types").getString(0);
					String short_name = curjo.getString("short_name");
					if (type.equals("postal_code")) {
						System.out.println("POSTAL_CODE: " + short_name);
						ret.put("zip", short_name);
					} else if (type.equals("administrative_area_level_3")) {
						System.out.println("CITY: " + short_name);
						ret.put("city", short_name);
					} else if (type.equals("administrative_area_level_2")) {
						System.out.println("PROVINCE: " + short_name);
						ret.put("province", short_name);
					} else if (type.equals("administrative_area_level_1")) {
						System.out.println("REGION: " + short_name);
						ret.put("region", short_name);
					}
				}
				return ret;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}