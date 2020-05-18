package com.echriwbi3.api.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Category extends CommonEntity {

	private String name;
	private String description;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Article> articles;
	@OneToOne(fetch = FetchType.EAGER)
	private Category parentCategory;
	private Integer categoryLevel;
	@Column(columnDefinition = "boolean default true")
	private boolean enabeled;

}