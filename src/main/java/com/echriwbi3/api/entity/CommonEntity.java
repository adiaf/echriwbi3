package com.echriwbi3.api.entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

@Data
public abstract class CommonEntity {

	@MongoId
	protected String id;

	@CreatedDate
	protected Date created;

	@LastModifiedDate
	protected Date updated;

	@Version
	private Long version;

}