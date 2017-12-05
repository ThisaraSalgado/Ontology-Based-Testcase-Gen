package com.finalyrSE.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.finalyrSE.model.Fulluserstory;
import com.finalyrSE.service.EntityExtractionService;
import com.finalyrSE.service.UserstoryService;

@Controller
public class UserstoryController {
	
	@Autowired
	UserstoryService userstoryService;
	
	@Autowired
	EntityExtractionService entityextractor;
	
	/*@RequestMapping(value="/", method=RequestMethod.GET)
	public String sayHello(ModelMap model,Map<String,Object> map){
		//model.addAttribute("message", "ONTOLOGY BASED TEST CASE GENERATION");
		System.out.println("yes");
		map.put("fulluserstory", new Fulluserstory());
		map.put("storyList", userstoryService.getAll());
		return "index";
	}*/
	
	@RequestMapping(value="/createnewstory",method=RequestMethod.POST)
	public String createNewStory(Map<String,Object> map,@ModelAttribute("fulluserstory") Fulluserstory fulluserstory,@RequestParam String actionButton,HttpServletRequest request){
		System.out.println("in createNewStory");
		map.put("fulluserstory", new Fulluserstory());
		return "userstory/userstoryTemplate"; 
	}
	
	@RequestMapping(value="/addnewstory",method=RequestMethod.POST)
	public String addNewStory(Fulluserstory fulluserstory,Map<String,Object> map,@RequestParam String actionButton) throws IOException{
		System.out.println("in addNewStory");
		if(actionButton.equals("Save")){
			map.put("userstoryname",fulluserstory.getUserstoryname());
			map.put("status",fulluserstory.getStatus());
			userstoryService.create(fulluserstory);
			map.put("storyList", userstoryService.getAll());
			return "index";
		}
		else if(actionButton.equals("Save and Generate")){
			System.out.println("in Save and Generate");
			map.put("userstoryname",fulluserstory.getUserstoryname());
			map.put("status",fulluserstory.getStatus());
			userstoryService.create(fulluserstory);
			String userstorytext=fulluserstory.getUserstoryname();
			String text=userstorytext.substring(0,userstorytext.indexOf("so that"));
			System.out.println(text);
			String t=text.replace("I need to be able to", "");
			System.out.println("t= "+t);
			ArrayList<String> entitylist=entityextractor.entityEx(t);
			System.out.println("Entity List = "+entitylist);
			//have to call jena here with these entities given as itsparameters//
			map.put("storyList", userstoryService.getAll());
			map.put("entity", entitylist);
			return "userstory/entities";
		}
		 return "index";
	}
	

	@RequestMapping(value="/viewuserstory/{userstoryId}",method=RequestMethod.GET)
	public String viewUserStory(@PathVariable("userstoryId") int userstoryId, Map<String,Object> map){
		System.out.println("in viewStory");
		System.out.println(userstoryId);
		Fulluserstory full=userstoryService.find(userstoryId);
		//map.put("storyList", userstoryService.getAll());
		map.put("storyList", full);
		return "userstory/userstory"; 
	}
	
	@RequestMapping(value="/viewuserstory/editdeletestory/{userstoryId}",method=RequestMethod.GET)
	public String editstory(@PathVariable("userstoryId") int userstoryId, Map<String,Object> map,@RequestParam String actionButton){
		if(actionButton.equals("Edit")){
			System.out.println("in edit");
			//System.out.println(actionButton);
			//System.out.println("edit num "+userstoryId);
			Fulluserstory full=userstoryService.find(userstoryId);
			map.put("fulluserstory", full);
			return "userstory/edit";
		}
		else if(actionButton.equals("Delete")){
			System.out.println("in delete");
			//System.out.println(actionButton);
			//System.out.println("delete num "+userstoryId);
			userstoryService.delete(userstoryId);
			System.out.println("deleted");
			return "redirect:/backtouserstory";
		}
		return null;
	}
	
	@RequestMapping(value="/updatestory/{userstoryId}",method=RequestMethod.POST)
	public String update(Fulluserstory fulluserstory, @PathVariable("userstoryId") int userstoryId,Map<String,Object> map){
		System.out.println("in update");
		System.out.println("update num"+userstoryId);
		userstoryService.update(fulluserstory);
		Fulluserstory full=userstoryService.find(userstoryId);
		map.put("storyList", full);
		return "userstory/userstory";
	}
	
	@RequestMapping(value="/backtouserstory",method=RequestMethod.GET)
	public String backbutton(Map<String,Object> map){
		map.put("fulluserstory", new Fulluserstory());
		map.put("storyList", userstoryService.getAll());
		return "index";
	}
	
	
	

}
