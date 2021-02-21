package com.bolsaideas.springboot.error.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bolsaideas.springboot.error.app.errors.UserNotFoundException;
import com.bolsaideas.springboot.error.app.models.domain.User;
import com.bolsaideas.springboot.error.app.services.UserService;

@Controller
public class AppController {

	@Autowired
	private UserService _userService;

	@SuppressWarnings("unused")
	@GetMapping("/index")
	public String index() {
		// Integer value = 100/0;
		Integer value = Integer.parseInt("xas");
		return "index";
	}

	@GetMapping("/view/{id}")
	public String view(@PathVariable Integer id, Model model) throws Exception {
		/*
		 * User userFound = _userService.getUserById(id); if (userFound == null) {
		 * //throw new Exception("Error Nuevo"); throw new
		 * UserNotFoundException(id.toString()); }
		 */

		User userFound = this._userService.getUserByIdOptional(id)
				.orElseThrow(() -> new UserNotFoundException(id.toString()));

		model.addAttribute("user", userFound);
		model.addAttribute("title", "User Detail: ".concat(userFound.getName()));
		return "view";
	}

	@GetMapping("/view")
	public String view(Model model) {
		model.addAttribute("userList", _userService.getUsers());
		model.addAttribute("title", "Users List");
		return "usersList";
	}

}
