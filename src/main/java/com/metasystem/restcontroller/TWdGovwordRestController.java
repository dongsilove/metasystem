package com.metasystem.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.metasystem.repository.TWdGovwordRepository;


@RestController
public class TWdGovwordRestController<TWdGovword> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	TWdGovwordRepository govwordRepository;

	@GetMapping("/govwords")
	public List<TWdGovword> list() throws Exception {
		
		@SuppressWarnings("unchecked")
		List<TWdGovword> list = (List<TWdGovword>) govwordRepository.findAll();
		return list;
	}
	
	
}
