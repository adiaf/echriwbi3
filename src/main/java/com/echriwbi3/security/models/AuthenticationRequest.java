package com.echriwbi3.security.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

}