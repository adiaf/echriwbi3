package com.echriwbi3.api.entity.accessManagement;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.echriwbi3.api.entity.CommonEntity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class User extends CommonEntity {

    @NotNull
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    @NotNull
    private String password;
    @NotNull
    private Date expirationDate;
    @NotNull
    private Date credentialsExpirationDate;
    @NotNull
    private boolean locked;
    @NotNull
    private boolean active;

    private List<Role> roles;

}