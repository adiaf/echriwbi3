package com.echriwbi3.api.entity;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Article extends CommonEntity{
	
	private String name;
	private String description;
	
}