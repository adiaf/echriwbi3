package com.echriwbi3.api.controllers;

import java.util.ArrayList;
import java.util.List;

import com.echriwbi3.api.entity.Farmer;
import com.echriwbi3.api.security.JwtUtil;
import com.echriwbi3.api.security.MysqlUserDetailsService;
import com.echriwbi3.api.security.models.AuthenticationRequest;
import com.echriwbi3.api.security.models.AuthenticationResponse;
import com.echriwbi3.api.service.FarmerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class FarmerController {

	@Autowired
	FarmerService farmerService;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	MysqlUserDetailsService mysqlUserDetailsService;
	
	@Autowired
	JwtUtil jwtUtil;

	@RequestMapping("/admin")
	public List<Farmer> getAllFarmers() {
		final List<Farmer> result = new ArrayList<Farmer>();
		farmerService.findAll().forEach(result::add);
		return result;
	}
	
	@RequestMapping(value = "/admin",method = RequestMethod.POST)
	public Farmer addFarmer(@RequestBody Farmer farmer) {
		return farmerService.save(farmer);
	}
	
	@RequestMapping("/")
	public String whelcom() {

		return "Welcom";

	}
	@RequestMapping(value = "/authenticate",method = RequestMethod.POST)
	public ResponseEntity<?> createAthentificationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{

		try {
			authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = mysqlUserDetailsService.loadUserByUsername(authenticationRequest.getUsername()) ;

		final String jwtToken = jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwtToken));
	}
}
