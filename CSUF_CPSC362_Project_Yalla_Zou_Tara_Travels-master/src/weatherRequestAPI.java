import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.*;
import com.google.gson.reflect.*;


public class WeatherRequestAPI {
	private static String API_KEY = "79b1e5c955fca00689bf8feb0e50b2b4";
	
	private static Map<String, Object> jsonToMap(String str){
		Map<String, Object> map= new Gson().fromJson(
			str, new TypeToken<HashMap<String, Object>>(){}.getType());
		return map;
	}
	
	public static String getCityWeatherInfo(String city) {
		StringBuilder weatherInfo = new StringBuilder();
		String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid="+ WeatherRequestAPI.API_KEY + "&units=imperial";
		
		try {
			StringBuilder result = new StringBuilder();	
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			BufferedReader rd = new BufferedReader (new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine())  != null )
			{
				result.append(line);
			}
			rd.close();
			
			Map<String, Object> respMap = jsonToMap (result.toString());
			List<Object> weatherList = (List<Object>)respMap.get("weather");
			String weatherListStr = weatherList.get(0).toString();
			
			String[] weatherEntries = weatherListStr.substring(1, weatherListStr.length() - 1).split(","); 
			String weatherStr = "";
			for (String e : weatherEntries) {
				String[] entry = e.trim().split("=");
				if (entry[0].equals("main")) {
					weatherStr = entry[1];
				}
			}
			
			Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
				
			weatherInfo.append("Current weather in " + city+ ": " + weatherStr + "\n");
			weatherInfo.append("Current temperature: " + mainMap.get("temp") + " degrees\n");
			weatherInfo.append("Current Humidity: " + mainMap.get("humidity") + "%\n");	
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return weatherInfo.toString();
	}

}
