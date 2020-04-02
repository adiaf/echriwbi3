package com.echriwbi3.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.echriwbi3.api.entity.Farmer;

@Repository
public interface FarmerRepository extends CrudRepository<Farmer, Integer> {

}
