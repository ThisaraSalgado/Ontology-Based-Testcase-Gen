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
import com.finalyrSE.service.JenaTestService;
import com.finalyrSE.service.TripletExtracionService;
import com.finalyrSE.service.UserstoryService;

@Controller
public class UserstoryController {
	
	@Autowired
	UserstoryService userstoryService;
	
	@Autowired
	EntityExtractionService entityextractor;
	
	@Autowired
	TripletExtracionService tripletex;
	
	@Autowired
	JenaTestService jenaService;
	
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
		if (actionButton.equals("Create new Userstory")){
		System.out.println("in createNewStory");
		map.put("fulluserstory", new Fulluserstory());
		return "userstory/userstoryTemplate"; 
		}
		if (actionButton.equals("Delete Selected")){
			 int [] checkedlist={35,36,37,38,39,40};
			 for(int i=0;i<checkedlist.length;i++){
				 int userstoryId=checkedlist[i];
				 //userstoryService.delete(userstoryId);
				 System.out.println(checkedlist[i]);
				 System.out.println("delete#######selected inside for");
			 }
			 
			 System.out.println("delete#######selected");
			
			map.put("storyList", userstoryService.getAll());
			//System.out.println(a);
			return "index"; 
			}
		
		return null;
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
			System.out.println(fulluserstory.getUserstoryname());
			map.put("status",fulluserstory.getStatus());
			userstoryService.create(fulluserstory);
			String userstorytext=fulluserstory.getUserstoryname();
		
			//have to call jena here with these entities given as itsparameters//
			ArrayList<String> entitylist=tripletex.extractTriplets(userstorytext);
			String user=entitylist.get(0);
			String predicate=entitylist.get(1);
			String object=entitylist.get(2);
			jenaService.jenaWithParam(user, predicate, object);
			
			map.put("storyList", userstoryService.getAll());
			map.put("entity", entitylist);
			return "userstory/entities";
		}
		 return null ;
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
		if(actionButton.equals("Delete")){
			System.out.println("in delete");
			//System.out.println(actionButton);
			//System.out.println("delete num "+userstoryId);
			userstoryService.delete(userstoryId);
			System.out.println("deleted");
			return "redirect:/backtouserstory";
		}
		else if(actionButton.equals("Generate")){
			System.out.println(actionButton);
			Fulluserstory full=userstoryService.find(userstoryId);
			System.out.println("in Generate >>>updatestory/editdeletestory");
			System.out.println(userstoryId);
			map.put("userstoryname",full.getUserstoryname());
			System.out.println(full.getUserstoryname());
			map.put("status",full.getStatus());
			userstoryService.create(full);
			String userstorytext=full.getUserstoryname();
			
			String text=userstorytext.substring(0,userstorytext.indexOf("so that"));
			System.out.println(text);
			String t=text.replace("I need to be able to", "");
			System.out.println("t= "+t);
			/*ArrayList<String> entitylist=entityextractor.entityEx(t);
			System.out.println("Entity List = "+entitylist);
			//have to call jena here with these entities given as itsparameters//
			map.put("storyList", userstoryService.getAll());
			map.put("entity", entitylist);*/
			return "userstory/entities";
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
		
		System.out.print(full.getAssignee());
		return "userstory/userstory";
	}
	
	@RequestMapping(value="/updatestory/editdeletestory/{userstoryId}",method=RequestMethod.GET)
	public String editstoryu(@PathVariable("userstoryId") int userstoryId, Map<String,Object> map,@RequestParam String actionButton){
		if(actionButton.equals("Edit")){
			System.out.println("in edit");
			//System.out.println(actionButton);
			//System.out.println("edit num "+userstoryId);
			Fulluserstory full=userstoryService.find(userstoryId);
			map.put("fulluserstory", full);
			return "userstory/edit";
		}
		if(actionButton.equals("Delete")){
			System.out.println("in delete");
			//System.out.println(actionButton);
			//System.out.println("delete num "+userstoryId);
			userstoryService.delete(userstoryId);
			System.out.println("deleted");
			return "redirect:/backtouserstory";
		}
		else if(actionButton.equals("Generate")){
			System.out.println(actionButton);
			Fulluserstory full=userstoryService.find(userstoryId);
			System.out.println("in Generate >>>updatestory/editdeletestory");
			System.out.println(userstoryId);
			map.put("userstoryname",full.getUserstoryname());
			System.out.println(full.getUserstoryname());
			map.put("status",full.getStatus());
			userstoryService.create(full);
			String userstorytext=full.getUserstoryname();
			
			String text=userstorytext.substring(0,userstorytext.indexOf("so that"));
			System.out.println(text);
			String t=text.replace("I need to be able to", "");
			System.out.println("t= "+t);
			/*ArrayList<String> entitylist=entityextractor.entityEx(t);
			System.out.println("Entity List = "+entitylist);
			//have to call jena here with these entities given as itsparameters//
			map.put("storyList", userstoryService.getAll());
			map.put("entity", entitylist);*/
			return "userstory/entities";
			//return "redirect:/addnewstory";
		}
		return null;
	}
	

	
	
	@RequestMapping(value="/backtouserstory",method=RequestMethod.GET)
	public String backbutton(Map<String,Object> map){
		map.put("fulluserstory", new Fulluserstory());
		map.put("storyList", userstoryService.getAll());
		return "index";
	}
	
	
	

}
