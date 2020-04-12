package com.echriwbi3.api.entity.accessManagement;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.echriwbi3.api.entity.CommonEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class User extends CommonEntity{

    @Column(unique = true)
    @NotNull
    private String username;
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    public User(Long id, String username, String password, Date expirationDate, Date credentialsExpirationDate,
            boolean locked, boolean active, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.expirationDate = expirationDate;
        this.credentialsExpirationDate = credentialsExpirationDate;
        this.locked = locked;
        this.active = active;
        this.roles = roles;
    }


}