package com.echriwbi3.api.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.echriwbi3.api.entity.Farmer;
import com.echriwbi3.api.repository.FarmerRepository;

@CrossOrigin(origins = "*")
@RestController
public class FarmerController {
	
	@Autowired FarmerRepository farmerRepository;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(name = "/")
	public List<Farmer> getAllFarmers(){
		
		List<Farmer> result = new ArrayList<Farmer>();
		farmerRepository.findAll().forEach(result::add);

		
		
		return result;
		
	}
}
