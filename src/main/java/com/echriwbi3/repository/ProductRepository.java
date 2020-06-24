package com.echriwbi3.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.echriwbi3.model.Product;

@RepositoryRestResource
public interface ProductRepository extends MongoRepository<Product, String> {

}
