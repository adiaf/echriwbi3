package com.echriwbi3.api.repository;

import com.echriwbi3.api.entity.accessManagement.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<User, Long> {

}
