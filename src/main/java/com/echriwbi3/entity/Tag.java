package com.echriwbi3.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.echriwbi3.entity.common.CommonEntity;

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