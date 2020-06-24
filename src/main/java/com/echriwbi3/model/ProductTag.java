package com.echriwbi3.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.echriwbi3.model.common.CommonEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document(collection = "product_tag")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class ProductTag extends CommonEntity {

	private String name;
	private String description;

}