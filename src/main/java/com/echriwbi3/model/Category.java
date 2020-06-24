package com.echriwbi3.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.echriwbi3.model.common.CommonEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document(collection = "category")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Category extends CommonEntity {
	@NotNull
	@Indexed(unique = true)
	private String name;

	private String description;

	@DBRef
	private Category parentCategory;

	private Integer categoryLevel;

	private boolean enabeled = true;

}