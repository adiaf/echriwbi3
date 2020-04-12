package com.echriwbi3.api.service;

import com.echriwbi3.api.entity.accessManagement.User;
import com.echriwbi3.api.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;


	public Iterable<User> findAll() {
		return roleRepository.findAll();
	}

	public User save(User user) {
		return roleRepository.save(user);
	}

	public void delete(Long id) {
		roleRepository.deleteById(id);
	}

	public User update(User user, Long id) {
        if (user.getId().equals(id)) {
            return roleRepository.save(user);
        }
		return null;
	}
}