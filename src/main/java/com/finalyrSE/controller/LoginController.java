package com.finalyrSE.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finalyrSE.model.CommonModel;
import com.finalyrSE.model.Fulluserstory;
import com.finalyrSE.model.User;
import com.finalyrSE.model.Userstory;
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
	public ModelAndView login(Map<String,Object> map,@ModelAttribute("user")User user,BindingResult result,HttpServletRequest request){
		//System.out.println("user name= "+user.getUsername());
		//System.out.println("password= "+user.getPassword());
		CommonModel commonModel=new CommonModel();
		List<Userstory> storyList=new ArrayList<Userstory>();
		
		boolean userExists = loginservice.CheckLogin(user.getUsername(),user.getPassword());
		if(userExists){
			System.out.println("logged succesfully");
			User valid = new User();
			valid = loginservice.getUser(user.getUsername());
			//model.put("loginForm", user);
			//map.put("fulluserstory", new Fulluserstory());
			//map.put("storyList", userstoryService.getAll());
			storyList=userstoryService.getAll();
			//System.out.println(storyList);
			System.out.println(valid.getUserrole());
			HttpSession session = request.getSession();
			session.setAttribute("role", valid.getUserrole());
			if(valid.getUserrole().equals("lead")){
				return null;
			}
			else{
				ModelAndView model=new ModelAndView("index", "commonModel", commonModel);
				model.addObject("storyList",storyList);
				return model;
			}
		}else{
			result.rejectValue("username","invaliduser");
			ModelAndView model=new ModelAndView("user/login", "commonModel", commonModel);
			((Model) model).addAttribute("message", "Username or Password is incorrect.");
			return model;
			
		}
	}
}	
