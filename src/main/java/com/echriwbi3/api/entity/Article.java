package com.echriwbi3.api.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Article extends CommonEntity {

	private String name;
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;

	@ManyToMany(fetch = FetchType.LAZY)
	private List<Tag> tags;
}