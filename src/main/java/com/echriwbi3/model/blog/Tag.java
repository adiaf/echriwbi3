package com.echriwbi3.model.blog;

import org.springframework.data.mongodb.core.mapping.Document;

import com.echriwbi3.model.common.CommonEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document(collection = "blog_tag")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Tag extends CommonEntity {

	private String name;
	private String description;
	private String slug;

}