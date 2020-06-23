package com.echriwbi3.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.echriwbi3.entity.Category;
import com.echriwbi3.entity.QCategory;
import com.echriwbi3.repository.CategoryRepository;
import com.querydsl.core.types.Predicate;

@Service
public class CaregoryService {
	@Autowired
	CategoryRepository categoryRepository;

	public List<Category> findByUsername(final Set<String> parenIds) {
		final QCategory qCategory = new QCategory("user");
		final Predicate predicate = qCategory.parentCategory.id.in(parenIds);

		return (List<Category>) categoryRepository.findAll(predicate);
	}

}