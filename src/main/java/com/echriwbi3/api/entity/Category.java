package com.echriwbi3.api.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document(collection = "category")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Category extends CommonEntity {

	private String name;
	private String description;
	private List<Article> articles;
	private Category parentCategory;
	private Integer categoryLevel;
	private boolean enabeled = true;

	private List<Category> childrenCategories;

}