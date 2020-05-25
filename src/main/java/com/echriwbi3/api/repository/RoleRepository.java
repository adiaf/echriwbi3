package com.echriwbi3.api.repository;

import com.echriwbi3.api.entity.accessManagement.Role;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "roles", path = "roles")
public interface RoleRepository extends MongoRepository<Role, String> {

}
