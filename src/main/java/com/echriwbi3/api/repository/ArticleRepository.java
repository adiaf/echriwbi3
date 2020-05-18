package com.echriwbi3.api.repository;

import com.echriwbi3.api.entity.Article;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
