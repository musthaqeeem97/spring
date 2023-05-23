package com.example.springsecurity6.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	 @GetMapping("/")
	    public String home(){
	        return "home";
	    }

	    @GetMapping("/login")
	    public String showLoginForm(Model model) {

	    	/*
	    	SecurityContextHolder.getContext().getAuthentication() retrieves the 
	    	currently authenticated user's Authentication object from the security context. 
	    	The SecurityContextHolder is a thread-local holder for 
	    	security-related information in a Spring application.
	    	*/	 
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
	            return "login";
	        }

	        return "redirect:/";
	    }
}
