package com.echriwbi3.api.security.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.echriwbi3.api.entity.accessManagement.User;
import com.echriwbi3.api.security.models.MysqlUserDetails;
import com.echriwbi3.api.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MysqlUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public MysqlUserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final Optional<User> user = userService.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("No user found with username " + username));

        final Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        user.get().getRoles().stream().forEach(role -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });

        return new MysqlUserDetails(
            user.get().getId(), 
            user.get().getUsername(), 
            user.get().getPassword(), 
            (new Date()).compareTo(user.get().getExpirationDate()) > 0,
            !user.get().isLocked(), 
            (new Date()).compareTo(user.get().getCredentialsExpirationDate()) > 0, 
            user.get().isActive(), 
            grantedAuthorities
        );
    }

    public MysqlUserDetails loadUserById(final Long id) throws UsernameNotFoundException {
        final Optional<User> user = userService.findById(id);
        user.orElseThrow(() -> new UsernameNotFoundException("No user found with username " + id));

        final Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        user.get().getRoles().stream().forEach(role -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });

        return new MysqlUserDetails(
            user.get().getId(), 
            user.get().getUsername(), 
            user.get().getPassword(), 
            (new Date()).compareTo(user.get().getExpirationDate()) > 0,
            !user.get().isLocked(), 
            (new Date()).compareTo(user.get().getCredentialsExpirationDate()) > 0, 
            user.get().isActive(), 
            grantedAuthorities
        );
    }

}