package com.bolsaideas.springboot.error.app.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bolsaideas.springboot.error.app.errors.UserNotFoundException;

@ControllerAdvice //It maps to an exception
public class ErrorHandlerController {
	
	@ExceptionHandler(ArithmeticException.class)
	public String arithmeticError(Exception ex, Model model) {
		model.addAttribute("error", "There is an arithmetic error");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/arithmetic";
	}
	
	
	@ExceptionHandler(NumberFormatException.class)
	public String numberFormatException(NumberFormatException ex, Model model) {
		model.addAttribute("error", "There is a conversion error");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/number";
	}
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public String userNotFound(UserNotFoundException ex, Model model) {
		model.addAttribute("error", "The user not found");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/arithmetic";
	}
	
}
