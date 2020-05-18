package com.echriwbi3.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;

@MappedSuperclass
@Data
public class CommonEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	protected Long id;

	protected Date created;

	protected Date updated;

	@PrePersist
	public void onCreate() {
		this.created = new Date();
	}

	@PreUpdate
	public void onUpdate() {
		this.updated = new Date();
	}

}