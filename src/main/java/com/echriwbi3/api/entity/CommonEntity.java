package com.echriwbi3.api.entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "commonEntity")
@Data
public abstract class CommonEntity {
	@Id
	protected String id;

	@CreatedDate
	protected Date created;

	@LastModifiedDate
	protected Date updated;

}