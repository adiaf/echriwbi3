package com.echriwbi3.api.service;

import com.echriwbi3.api.entity.Farmer;
import com.echriwbi3.api.repository.FarmerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerService {
    @Autowired
    FarmerRepository FarmerRepository;

    public Iterable<Farmer> findAll() {
        return FarmerRepository.findAll();
    }
}