package com.echriwbi3.api.repository;

import com.echriwbi3.api.entity.Tag;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TagRepository extends MongoRepository<Tag, String> {

}
