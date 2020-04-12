package com.echriwbi3.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Farmer extends CommonEntity{
	
	@Column(name="name")
	private String name;
	
	@Column(name="village")
	private String village;
	
}