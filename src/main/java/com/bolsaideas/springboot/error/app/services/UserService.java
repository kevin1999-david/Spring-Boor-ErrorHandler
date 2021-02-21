package com.bolsaideas.springboot.error.app.services;

import java.util.List;
import java.util.Optional;

import com.bolsaideas.springboot.error.app.models.domain.User;

public interface UserService {
	
	public List<User> getUsers();
	public User getUserById(Integer id);
	public Optional<User> getUserByIdOptional(Integer id);

}
