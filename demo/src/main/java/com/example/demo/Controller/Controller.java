package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@GetMapping("create")
	public String create() {
		return "Data is stored";
	}
	@GetMapping("read")
	public String read() {
		return "Data is retrieved";
	}
	@GetMapping("update")
	public String update() {
		return "Data is updated";
	}
	@GetMapping("delete")
	public String delete() {
		return "Data is deleted";
	}

}
