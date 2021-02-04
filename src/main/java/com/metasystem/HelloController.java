package com.metasystem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	public String hello() {
		return "안녕";
	}
	@RequestMapping("/index")
	public String index() throws Exception {
		return "index";
	}
}
