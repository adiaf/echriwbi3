package com.echriwbi3.api.security.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class AuthenticationResponse implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private final String jwt;
}