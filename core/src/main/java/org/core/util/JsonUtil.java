package org.core.util;

import java.util.Collection;

import org.core.view.JSONResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class JsonUtil {

	public static ResponseEntity<JSONResponse<?>> convertIntoJson(Collection<?> records) {
		
		try{
			JSONResponse<Collection<?> > jsonResp = new JSONResponse<>();
			jsonResp.setData(records);
			jsonResp.setMessage("Success");
			jsonResp.setStatus("OK");
			return HttpUtils.getResponseEntity(jsonResp, HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			return HttpUtils.<JSONResponse<?>>getResponseEntity(new JSONResponse<String>(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	public static <E> ResponseEntity<JSONResponse<?>> convertSingleEntityToJson(E records) {
		
		try{
			JSONResponse<E> jsonResp = new JSONResponse<>();
			jsonResp.setData(records);
			jsonResp.setMessage("Success");
			jsonResp.setStatus("OK");
			return HttpUtils.getResponseEntity(jsonResp, HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			return HttpUtils.<JSONResponse<?>>getResponseEntity(new JSONResponse<String>(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	public static <E> ResponseEntity<JSONResponse<?>> JsonForError(E ErrorMessage) {
		
		try{
			JSONResponse<E> jsonResp = new JSONResponse<>();
			jsonResp.setMessage(ErrorMessage.toString());
			jsonResp.setData(ErrorMessage);
			jsonResp.setStatus("ERROR");
			return HttpUtils.getResponseEntity(jsonResp, HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			return HttpUtils.<JSONResponse<?>>getResponseEntity(new JSONResponse<String>(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}