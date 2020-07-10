package com.echriwbi3.model.blog;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.echriwbi3.model.common.CommonEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document(collection = "blog_article")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Article extends CommonEntity {

	@NotEmpty
	private String title;
	@NotEmpty
	private String slug;
	private String content;
	private Author author;
	private int read;
	@DBRef
	private Category category;
	@DBRef
	private List<Tag> tags = new ArrayList<>();;
	private boolean enabled = false;

	private boolean enVedette = false;

	private boolean featured = false;

}