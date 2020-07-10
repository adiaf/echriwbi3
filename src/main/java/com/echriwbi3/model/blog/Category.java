package com.echriwbi3.model.blog;

import org.springframework.data.mongodb.core.mapping.Document;

import com.echriwbi3.model.common.CommonEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document(collection = "blog_category")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Category extends CommonEntity {

	private String title;
	private String slug;

	private String color;
	private boolean showOnMenu = true;
	private boolean enabled = true;
	private int order = 0;

}