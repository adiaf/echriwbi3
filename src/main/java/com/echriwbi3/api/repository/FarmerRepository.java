package com.echriwbi3.api.repository;

import com.echriwbi3.api.entity.Farmer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerRepository extends CrudRepository<Farmer, Integer> {

}
