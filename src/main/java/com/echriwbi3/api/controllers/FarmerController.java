package com.echriwbi3.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.echriwbi3.api.entity.Farmer;
import com.echriwbi3.api.service.FarmerService;

@CrossOrigin(origins = "*")
@RestController
public class FarmerController {

	@Autowired
	FarmerService farmerService;

	@RequestMapping(name = "/")
	public List<Farmer> getAllFarmers() {

		final List<Farmer> result = new ArrayList<Farmer>();
		farmerService.findAll().forEach(result::add);

		return result;

	}
}
