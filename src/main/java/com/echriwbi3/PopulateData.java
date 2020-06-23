package com.echriwbi3;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.echriwbi3.entity.accessManagement.ERole;
import com.echriwbi3.entity.accessManagement.Role;
import com.echriwbi3.entity.accessManagement.User;
import com.echriwbi3.repository.UserRepository;

@Component
public class PopulateData implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		if (!userRepository.existsByUsername("adf")) {
			userRepository.deleteAll();
			Set<Role> roles = new HashSet<>();
			roles.add(new Role(ERole.ROLE_ADMIN));
			roles.add(new Role(ERole.ROLE_USER));

			User user = new User("adf", "Abderahmane", "DIAF", "a.diaf@icloud.com",
					"$2a$10$8Zs9WYLX77m5T.EIthx4CupwaCJ1DNX0IRDdhPJmIgdT/XJZjvrum", roles);
			userRepository.save(user);
		}

	}
}