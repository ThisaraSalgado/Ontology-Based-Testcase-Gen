package com.finalyrSE.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.finalyrSE.model.Fulluserstory;
import com.finalyrSE.model.User;
import com.finalyrSE.service.LoginService;
import com.finalyrSE.service.UserstoryService;

@Controller
public class LoginController {
	
	@Autowired
	UserstoryService userstoryService;
	
	@Autowired
	LoginService loginservice;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcome(Model model){
		model.addAttribute("user", new User());
		return "user/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Map<String,Object> map,@ModelAttribute("user")User user,BindingResult result,Model model){
		//System.out.println("user name= "+user.getUsername());
		//System.out.println("password= "+user.getPassword());
		
		boolean userExists = loginservice.CheckLogin(user.getUsername(),user.getPassword());
		if(userExists){
			System.out.println("logged succesfully");
			//model.put("loginForm", user);
			map.put("fulluserstory", new Fulluserstory());
			map.put("storyList", userstoryService.getAll());
			return "index";
		}else{
			result.rejectValue("username","invaliduser");
			model.addAttribute("message", "Username or Password is incorrect.");
			return "user/login";
		}
		
		
		
		
	}
}
