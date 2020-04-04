package com.echriwbi3.api.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getCredentialsExpirationDate() {
        return credentialsExpirationDate;
    }

    public void setCredentialsExpirationDate(Date credentialsExpirationDate) {
        this.credentialsExpirationDate = credentialsExpirationDate;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

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

    @Override
    public String toString() {
        return "User [active=" + active + ", credentialsExpirationDate=" + credentialsExpirationDate
                + ", expirationDate=" + expirationDate + ", id=" + id + ", locked=" + locked + ", password=" + password
                + ", userName=" + username + "]";
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public User() {
    }

}