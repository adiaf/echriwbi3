package com.echriwbi3.api.controllers;

import java.util.ArrayList;
import java.util.List;

import com.echriwbi3.api.entity.accessManagement.User;
import com.echriwbi3.api.service.RoleService;
import com.echriwbi3.api.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("access-management")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AccessManagementController {

    @Autowired 
    UserService userservice;
    @Autowired 
    RoleService roleService;

    @GetMapping("/users")
	public List<User> getAllUsers() {
		return userservice.findAll();
    }

    @RequestMapping(value = "/users",method = RequestMethod.POST)
	public User AddUser(@RequestBody User user) {
		return userservice.save(user);
    }
    
    @RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable Long id) {
		userservice.delete(id);
    }

    @RequestMapping(value = "/users/{id}",method = RequestMethod.PUT)
	public User updateUser(@PathVariable Long id,@RequestBody User user) {
		return userservice.update(user,id);
    }
    
    @RequestMapping("/roles")
	public List<User> getAllRoles() {
		final List<User> result = new ArrayList<User>();
		roleService.findAll().forEach(result::add);
		return result;
    }

    @RequestMapping(value = "/roles",method = RequestMethod.POST)
	public User AddRole(@RequestBody User user) {
		return roleService.save(user);
    }
    
    @RequestMapping(value = "/roles/{id}",method = RequestMethod.DELETE)
	public void deleteRole(@PathVariable Long id) {
		roleService.delete(id);
    }

    @RequestMapping(value = "/roles/{id}",method = RequestMethod.PUT)
	public User updateRole(@PathVariable Long id,@RequestBody User user) {
		return roleService.update(user,id);
    }
    
}