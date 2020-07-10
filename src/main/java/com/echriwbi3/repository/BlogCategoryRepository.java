package com.echriwbi3.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.echriwbi3.model.blog.Category;

public interface BlogCategoryRepository extends MongoRepository<Category, String>, QuerydslPredicateExecutor<Category> {

}
