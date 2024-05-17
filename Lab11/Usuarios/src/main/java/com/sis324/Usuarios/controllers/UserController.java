package com.sis324.Usuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sis324.Usuarios.services.UserService;
import com.sis324.Usuarios.models.User;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	// @Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<User> showUsers() {
		return userService.getUsers();
	}
	@GetMapping(value = "/{id}")
	public List<User> showUsersAdult() {
		return userService.getUsers();
	}
	
	@PostMapping
	public User insert(@RequestBody User user) {
		return userService.create(user);
	}

	@PutMapping
	public User edit(@RequestBody User user) {
		return userService.create(user);
	}

	@DeleteMapping(value = "/{id}")
	public boolean delete(@PathVariable Long id) {
		return userService.delete(id);
	}
}
