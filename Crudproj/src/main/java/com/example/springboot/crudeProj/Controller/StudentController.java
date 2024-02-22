package com.example.springboot.crudeProj.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
	@GetMapping("/create")
	public String createStudent() {
		return "create";
	}
	@GetMapping("/read")
	public String readStudent() {
		return "read";
	}
	@GetMapping("/update")
	public String updateStudent() {
		return "update";
	}
	@GetMapping("/delete")
	public String deleteStudent() {
		return "delete";
	}
	

}
