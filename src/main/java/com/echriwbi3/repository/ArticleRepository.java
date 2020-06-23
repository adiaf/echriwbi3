package com.echriwbi3.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.echriwbi3.entity.Article;

@RepositoryRestResource
public interface ArticleRepository extends MongoRepository<Article, String> {

}
