package com.echriwbi3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.echriwbi3.repository.BlogArticleRepository;

@Service
public class BlogService {
	@Autowired
	BlogArticleRepository blogArticleRepository;
}
