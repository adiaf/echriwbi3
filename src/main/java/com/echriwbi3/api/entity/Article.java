package com.echriwbi3.api.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document(collection = "article")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Article extends CommonEntity {

	private String name;
	private String description;

	@DBRef
	private Category category;

	@DBRef
	private List<Tag> tags;
}