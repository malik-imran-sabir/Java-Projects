package org.core.web.controller;

import java.util.Collection;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.apache.log4j.Logger;
import org.core.service.CRUDService;
import org.core.util.HttpUtils;
import org.core.view.JSONResponse;
import org.core.vo.BaseVO;



public abstract class BaseController<E extends BaseVO> {

	
	protected CRUDService<E> service;
	private Logger logger = Logger.getLogger(getClass());
	
	public BaseController(CRUDService<E> service) {
		this.service = service;
	}
	
	@PostMapping(path="/")
	public ResponseEntity<JSONResponse<?>> post(@RequestBody E body, HttpServletRequest requst, HttpServletResponse response) throws Throwable {
		return update(body,requst,response);
	}

	@PutMapping(path="/")
	public ResponseEntity<JSONResponse<?>> put(@RequestBody  E body, HttpServletRequest requst, HttpServletResponse response)throws Throwable{
		return save(body,requst,response);
	}

	@GetMapping(path="/{id}")
	public ResponseEntity<JSONResponse<?>> list(@PathVariable("id") String id ,HttpServletRequest requst, HttpServletResponse response)throws Throwable {
		return getById(id,requst,response);
	}

	@GetMapping(path="/")
	public ResponseEntity<JSONResponse<?>> listAll(HttpServletRequest requst, HttpServletResponse response)throws Throwable {
		return getAll(requst,response);
	}
	
	@DeleteMapping(path="/")
	public ResponseEntity<JSONResponse<?>> delete(@RequestBody Long[] ids, HttpServletRequest requst, HttpServletResponse response)throws Throwable {
		logger.info("Ids : "+ids);
		return remove(ids, requst,response);
	}
	
	
	protected ResponseEntity<JSONResponse<?>> save(E body, HttpServletRequest request, HttpServletResponse response) throws Throwable {

		try{
			logger.info("REQUEST BODY : "+body);
			
			body = service.save(body);
			
			JSONResponse<E> jsonResp = new JSONResponse<>();
			System.out.println("Accessible");
			jsonResp.setData(body);
			jsonResp.setMessage("Success");
			jsonResp.setStatus("OK");
			return HttpUtils.getResponseEntity(jsonResp, HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			return HttpUtils.<JSONResponse<?>>getResponseEntity(new JSONResponse<String>(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	
	protected ResponseEntity<JSONResponse<?>> update(E body, HttpServletRequest request, HttpServletResponse response)
			throws Throwable {
		
		try{
			body = service.update(body);
			JSONResponse<E> jsonResp = new JSONResponse<>();
			System.out.println("Accessible");
			jsonResp.setData(body);
			jsonResp.setMessage("Success");
			jsonResp.setStatus("OK");
			return  HttpUtils.getResponseEntity(jsonResp, HttpStatus.OK);
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			return HttpUtils.<JSONResponse<?>>getResponseEntity(new JSONResponse<String>(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	
	protected ResponseEntity<JSONResponse<?>> getById(String Id, HttpServletRequest request, HttpServletResponse response)
			throws Throwable {
		try{
			E record = service.getById(Id);
			JSONResponse<E> jsonResp = new JSONResponse<>();
			jsonResp.setData(record);
			jsonResp.setMessage("Success");
			jsonResp.setStatus("OK");
	
			return HttpUtils.getResponseEntity(jsonResp, HttpStatus.OK);
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			
			return HttpUtils.<JSONResponse<?>>getResponseEntity(new JSONResponse<String>(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	protected ResponseEntity<JSONResponse<?>> getAll(HttpServletRequest request, HttpServletResponse response)
			throws Throwable {

		try{
			Collection<?> records = service.getAll();
			JSONResponse<Collection<?> > jsonResp = new JSONResponse<>();
			jsonResp.setData(records);
			jsonResp.setMessage("Success");
			jsonResp.setStatus("OK");
	
			return HttpUtils.getResponseEntity(jsonResp, HttpStatus.OK);
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			return HttpUtils.<JSONResponse<?>>getResponseEntity(new JSONResponse<String>(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	protected ResponseEntity<JSONResponse<?>> remove(Long[] id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		try{
			JSONResponse<?> jsonResp = new JSONResponse<>();

			service.remove(id);
			jsonResp.setMessage("Success");
			jsonResp.setStatus("OK");
	
			return  HttpUtils.getResponseEntity(jsonResp, HttpStatus.OK);
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			
			return HttpUtils.<JSONResponse<?>>getResponseEntity(new JSONResponse<String>(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
