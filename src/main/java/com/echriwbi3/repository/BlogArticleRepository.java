package com.echriwbi3.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.echriwbi3.model.blog.Article;

@RepositoryRestResource
public interface BlogArticleRepository extends MongoRepository<Article, String>, QuerydslPredicateExecutor<Article> {

	Page<Article> findByEnabledTrue(Pageable pageable);

	Page<Article> findByAuthorNameAndEnabledTrue(@Param("author_name") String name, Pageable pageable);

	Page<Article> findByTagsNameAndEnabledTrue(@Param("tag_name") String name, Pageable pageable);

}
