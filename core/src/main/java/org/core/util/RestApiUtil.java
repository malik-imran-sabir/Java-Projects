package org.core.util;

import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class RestApiUtil {
	
	public static String consumeRestCall(String url) {
		RestTemplate restTemplate = new RestTemplate();
		 return restTemplate.getForObject(url, String.class);
		
	}
	
	
	public static String getJsondata(String jsonKey, String result) {
		Gson gson = new Gson();
		JsonObject o = gson.fromJson(result, JsonObject.class);
		String value = "";
		
		if(o.get("data") instanceof JsonObject) {
			JsonObject ob = (JsonObject) o.get("data");
			value = ob.get(jsonKey).toString();
		
		} else if(o.get("data") instanceof JsonArray) {
			JsonArray jsonArray = (JsonArray) o.get("data");
			for(JsonElement j : jsonArray) {
				JsonObject ob = j.getAsJsonObject();
				value = ob.get(jsonKey).getAsString();
			}
				
		}
		
		value = (!"".equals(value) && value !=null) ? value.replaceAll("\"", "") : "";		
		return value;

	}
}
