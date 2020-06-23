package com.echriwbi3.api.security.models;

import java.util.Set;

import com.echriwbi3.api.entity.accessManagement.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class ConnectedUser {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String jwt;
    private Set<Role> roles;
}