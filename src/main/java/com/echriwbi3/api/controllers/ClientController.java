package com.echriwbi3.api.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
	@RequestMapping(name = "/")
	public List<String> getAllClients(){
		return Arrays.asList("A","B","C");
		
	}
}
