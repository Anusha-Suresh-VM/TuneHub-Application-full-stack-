package com.example.springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class NavController {
	@GetMapping("/map-register")
	public String registerMapping() {
		return "register";
	}
	@GetMapping("/map-login")
	public String loginMapping() {
		return "login";
	}
	@GetMapping("/map-songs")
	public String mapSongs() {
		return "addSongs";
	}
	@GetMapping("/payment")
	public String samplePayment() {
		return "payment";
	}
//	@GetMapping("/view-songs")
//	public String viewSongs() {
//		return "viewSongs";
//	}
	@GetMapping("/forgotPassword")
	public String forgotPassword() {
		return "forgotPassword";
	}
	

}
