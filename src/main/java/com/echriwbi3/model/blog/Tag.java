package com.echriwbi3.model.blog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag {

	private String name;
	private String description;

	public Tag(String name) {
		this.name = name;
	}
}