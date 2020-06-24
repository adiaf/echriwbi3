package com.echriwbi3.model.blog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
	private String name;
	private String email;
	private String facebook;
	private String linkedin;

	public Author(String name, String email) {
		this.name = name;
		this.email = email;
	}
}
