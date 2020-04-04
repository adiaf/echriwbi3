package com.echriwbi3.api.repository;

import java.util.List;

import com.echriwbi3.api.entity.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    public List<User> findByUsername(String username);
}
