package com.example.springboot.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.Services.ForgotPasswordService;
import com.example.springboot.Services.UsersService;
import com.example.springboot.entities.ForgotPassword;
import com.example.springboot.entities.User;

@RestController
public class ForgotPasswordController {
	@Autowired
	UsersService userv;
	@Autowired
	ForgotPasswordService fpserv;
	@PostMapping("/reset-password")
	public ResponseEntity<String>forgotPassword(@RequestParam String email){
		User user=userv.getUser(email);
		if(user==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email is not registered");
		}
		
		ForgotPassword token=fpserv.createToken(email);
		return ResponseEntity.ok("Password reset email sent Successfully");
		
		
	}
	

}
