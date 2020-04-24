package com.echriwbi3.api.controllers;


import com.echriwbi3.api.security.models.AuthenticationRequest;
import com.echriwbi3.api.security.models.AuthenticationResponse;
import com.echriwbi3.api.security.service.JwtUtil;
import com.echriwbi3.api.security.service.MysqlUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AthentificationController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	MysqlUserDetailsService mysqlUserDetailsService;
	
	@Autowired
	JwtUtil jwtUtil;
	
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
