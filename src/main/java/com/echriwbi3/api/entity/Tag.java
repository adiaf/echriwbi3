package com.echriwbi3.api.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document(collection = "tag")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Tag extends CommonEntity {

	private String name;
	private String description;

}