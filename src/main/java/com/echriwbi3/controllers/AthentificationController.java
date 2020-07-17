package com.echriwbi3.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.echriwbi3.model.accessManagement.User;
import com.echriwbi3.security.models.AuthenticationRequest;
import com.echriwbi3.security.models.AuthenticationResponse;
import com.echriwbi3.security.models.ConnectedUser;
import com.echriwbi3.security.service.JwtUtil;
import com.echriwbi3.security.service.UserDetailsServiceImpl;
import com.echriwbi3.service.UserService;

@RestController
public class AthentificationController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserDetailsServiceImpl uerDetailsService;

	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	UserService userService;

	@CrossOrigin
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public ResponseEntity<?> ping() throws Exception {
		return ResponseEntity.ok("OK");
	}

	@CrossOrigin
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAthentificationToken(@RequestBody final AuthenticationRequest authenticationRequest)
			throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (final BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = uerDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwtToken = jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwtToken));
	}

	@RequestMapping(value = "/user-profile", method = RequestMethod.GET)
	public ConnectedUser getUserProfile(final HttpServletRequest request) throws UsernameNotFoundException {
		final String authorizationHeader = request.getHeader("Authorization");

		String username = null;
		String token = null;

		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			token = authorizationHeader.substring(7);
			username = jwtUtil.extractUsername(token);
		}
		final Optional<User> connectedUser = userService.findByUsername(username);
		connectedUser.orElseThrow(() -> new UsernameNotFoundException("No user found"));
		User c = connectedUser.get();
		return new ConnectedUser(c.getFirstName(), c.getLastName(), c.getUsername(), c.getEmail(), token, c.getRoles());
	}

}
