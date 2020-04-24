package com.echriwbi3.api.controllers;

import java.util.ArrayList;
import java.util.List;

import com.echriwbi3.api.entity.Farmer;
import com.echriwbi3.api.service.FarmerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class FarmerController {

	@Autowired
	FarmerService farmerService;

	@CrossOrigin(origins = "*")
	@RequestMapping("/admin")
	public List<Farmer> getAllFarmers() {
		final List<Farmer> result = new ArrayList<Farmer>();
		farmerService.findAll().forEach(result::add);
		return result;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/admin",method = RequestMethod.POST)
	public Farmer addFarmer(@RequestBody Farmer farmer) {
		return farmerService.save(farmer);
	}
	
	
}
