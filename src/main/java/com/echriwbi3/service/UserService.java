package com.echriwbi3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.echriwbi3.model.accessManagement.QUser;
import com.echriwbi3.model.accessManagement.User;
import com.echriwbi3.repository.UserRepository;
import com.querydsl.core.types.Predicate;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	PasswordEncoder passwordEncoder;

	public Optional<User> findByUsername(final String username) {

		QUser qUser = new QUser("user");
		Predicate predicate = qUser.username.eq(username);

		return userRepository.findOne(predicate);
	}

	public List<User> findAll() {
		final List<User> result = new ArrayList<User>();
		userRepository.findAll().forEach(result::add);
		result.stream().forEach(u -> u.setPassword(null));
		return result;
	}

	public User save(User user) {
		if (user.getPassword() != null && !user.getPassword().isEmpty()) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		}
		return userRepository.save(user);
	}

	public void delete(User user) {
		userRepository.delete(user);

	}

	public User update(User user, String id) {
		if (user.getId().equals(id)) {
			if (user.getPassword() != null && !user.getPassword().isEmpty()) {
				user.setPassword(passwordEncoder.encode(user.getPassword()));
			}
			return userRepository.save(user);
		}
		return null;
	}

	@Autowired
	public UserService(@Lazy PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

}