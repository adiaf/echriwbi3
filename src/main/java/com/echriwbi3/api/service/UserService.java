package com.echriwbi3.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.echriwbi3.api.entity.accessManagement.User;
import com.echriwbi3.api.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    public Optional<User> findByUsername(final String username) {

        final List<User> users = userRepository.findByUsername(username);
        return users.stream().findFirst();
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

	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	public User update(User user, Long id) {
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

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}
    

}