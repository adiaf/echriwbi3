package com.echriwbi3.api.service;

import com.echriwbi3.api.entity.accessManagement.Role;
import com.echriwbi3.api.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
	@Autowired
	RoleRepository roleRepository;

	public Iterable<Role> findAll() {
		return roleRepository.findAll();
	}

	public Role save(Role role) {
		return roleRepository.save(role);
	}

	public void delete(Long id) {
		roleRepository.deleteById(id);
	}

	public Role update(Role role, Long id) {
		if (role.getId().equals(id)) {
			return roleRepository.save(role);
		}
		return null;
	}
}