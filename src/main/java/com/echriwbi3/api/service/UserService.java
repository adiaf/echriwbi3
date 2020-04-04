package com.echriwbi3.api.service;

import java.util.List;
import java.util.Optional;

import com.echriwbi3.api.entity.User;
import com.echriwbi3.api.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Optional<User> findByUsername(final String username) {

        final List<User> users = userRepository.findByUsername(username);
        return users.stream().findFirst();
    }
}