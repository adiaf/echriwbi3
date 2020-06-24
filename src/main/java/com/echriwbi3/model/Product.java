package com.echriwbi3.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.echriwbi3.model.common.CommonEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document(collection = "product")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Product extends CommonEntity {

	private String name;
	private String description;

	@DBRef
	private Category category;

	@DBRef
	private List<ProductTag> tags;
}