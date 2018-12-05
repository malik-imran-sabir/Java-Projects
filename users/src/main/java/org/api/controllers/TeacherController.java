package org.api.controllers;

import org.api.services.impl.UserService;
import org.core.view.JSONResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/{id}/students")
	public ResponseEntity<JSONResponse<?>> saveUpdateUser(@PathVariable("id") long id) {
		return userService.Liststudents(id);
		
		// userService.saveStudent(user);
		 //return "Student : " +user.getName() +"has been added successfully";
	}
}
