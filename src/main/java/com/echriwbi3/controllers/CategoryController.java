package com.echriwbi3.api.controllers;

import com.echriwbi3.api.entity.Category;
import com.echriwbi3.api.repository.CategoryRepository;
import com.querydsl.core.types.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;

	@CrossOrigin
	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	public ResponseEntity<?> getFiltered(@QuerydslPredicate(root = Category.class) Predicate predicate,
			Pageable pageable) {
		return ResponseEntity.ok(categoryRepository.findAll(predicate, pageable));
	}

}
