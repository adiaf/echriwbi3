package com.echriwbi3.model.blog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

	private String id;
	private String title;
	private String slug;
	private String color;
	private long articlesCount = 0;

}