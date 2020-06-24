package com.echriwbi3.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.echriwbi3.model.accessManagement.User;

@RepositoryRestResource
public interface UserRepository extends MongoRepository<User, String>, QuerydslPredicateExecutor<User> {

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
