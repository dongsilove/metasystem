package com.metasystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TWdGovwordController {

	@GetMapping("/govwords")
	public String govwords() throws Exception {
		return "govwords";
	}
}
