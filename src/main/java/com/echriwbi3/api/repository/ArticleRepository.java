package com.echriwbi3.api.repository;

import com.echriwbi3.api.entity.Article;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepository extends MongoRepository<Article, String> {

}
