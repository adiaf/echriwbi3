package com.echriwbi3.model.blog;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.echriwbi3.model.common.CommonEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document(collection = "article")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Article extends CommonEntity {

	private String title;
	private String slug;
	private String content;
	private Author author;
	private boolean enabled = true;

	private List<Tag> tags;

}