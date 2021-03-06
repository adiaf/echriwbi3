package com.echriwbi3.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.echriwbi3.model.blog.Article;

public interface BlogArticleRepository extends MongoRepository<Article, String>, QuerydslPredicateExecutor<Article> {

}
