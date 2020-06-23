package com.echriwbi3.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.echriwbi3.entity.accessManagement.User;
import com.echriwbi3.security.models.UserDetailsImpl;
import com.echriwbi3.service.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserService userService;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		final Optional<User> user = userService.findByUsername(username);
		user.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user.get());
	}

}