package com.bolsaideas.springboot.error.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bolsaideas.springboot.error.app.models.domain.User;

@Service
public class UserServiceI implements UserService{

	private List<User> users;
	
	
 public UserServiceI() {
		this.users = new ArrayList<>();
		users.add(new User(1, "Kevin", "Catucuamba"));
		users.add(new User(2, "Erick", "Johnson"));
		users.add(new User(3, "Luis", "Campbell"));
		users.add(new User(4, "Richard", "Wallas"));
		users.add(new User(5, "Daniel", "Cruz"));
		users.add(new User(6, "Guido", "Klever"));
	}
	
	@Override
	public List<User> getUsers() {
		return this.users;
	}

	@Override
	public User getUserById(Integer id) {
		User userFound = null;
		for (User user : this.users) {
			if (user.getId().equals(id)) {
				userFound = user;
				break;
			}
		}
		return userFound;
	}

	@Override
	public Optional<User> getUserByIdOptional(Integer id) {
		User userFound = this.getUserById(id);
		return Optional.ofNullable(userFound);
	}

}
