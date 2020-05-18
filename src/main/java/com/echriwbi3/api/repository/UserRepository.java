package com.echriwbi3.api.repository;

import java.util.List;

import com.echriwbi3.api.entity.accessManagement.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByUsername(String username);
}
