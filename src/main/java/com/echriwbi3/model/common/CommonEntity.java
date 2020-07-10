package com.echriwbi3.model.common;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import lombok.Data;

@Data
public abstract class CommonEntity {

	@Id
	protected String id;

	@CreatedDate
	protected Date created;

	@LastModifiedDate
	protected Date updated;

	@Version
	private Long version;

}