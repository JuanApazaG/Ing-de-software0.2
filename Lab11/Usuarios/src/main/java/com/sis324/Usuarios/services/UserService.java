package com.sis324.Usuarios.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sis324.Usuarios.models.User;
import com.sis324.Usuarios.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@SuppressWarnings("null")
	public User create(User user) {
		return userRepository.save(user);
	}

	@SuppressWarnings("null")
	public boolean delete(Long id) {
		try {
			userRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}