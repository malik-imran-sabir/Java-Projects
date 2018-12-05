package org.api.util;

import java.util.Collection;

import org.core.util.HttpUtils;
import org.core.view.JSONResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class RestUtil {
	

	public String getJsondata(String jsonKey, String result) {
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

	public ResponseEntity<JSONResponse<?>> convertIntoJson(Collection<?> records) {

		try {
			JSONResponse<Collection<?>> jsonResp = new JSONResponse<>();
			jsonResp.setData(records);
			jsonResp.setMessage("Success");
			jsonResp.setStatus("OK");
			return HttpUtils.getResponseEntity(jsonResp, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.<JSONResponse<?>>getResponseEntity(new JSONResponse<String>(e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	public String getJsonData(String jsonKey, String result) {
		try {
			if (result != null && !"".equals(result))
				return getJsondata(jsonKey, result);
			else
				return "";

		} catch (Exception e) {
			return "";
		}
	}


}
