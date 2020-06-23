package com.echriwbi3.api.repository;

import com.echriwbi3.api.entity.accessManagement.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends MongoRepository<User, String>, QuerydslPredicateExecutor<User> {

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
