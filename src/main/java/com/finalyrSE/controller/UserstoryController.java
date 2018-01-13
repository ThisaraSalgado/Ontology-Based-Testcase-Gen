package com.finalyrSE.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.finalyrSE.model.CommonModel;
import com.finalyrSE.model.Epic;
import com.finalyrSE.model.Fulluserstory;
import com.finalyrSE.model.Testcase;
import com.finalyrSE.model.Userstory;
import com.finalyrSE.service.EntityExtractionService;
import com.finalyrSE.service.EpicService;
import com.finalyrSE.service.JenaTestService;
import com.finalyrSE.service.TestcaseService;
import com.finalyrSE.service.TripletExtracionService;
import com.finalyrSE.service.UserstoryService;

@Controller
public class UserstoryController {
	
	@Autowired
	UserstoryService userstoryService;
	
	@Autowired
	EpicService epicService;
	
	@Autowired
	EntityExtractionService entityextractor;
	
	@Autowired
	JenaTestService jenaService;
	
	@Autowired
	TestcaseService testcaseService;
	
	@RequestMapping(value="/createnewstory",method=RequestMethod.POST)
	public ModelAndView createNewStory(Map<String,Object> map,@ModelAttribute("commonModel") CommonModel commonModel,@RequestParam String actionButton,HttpServletRequest request){
		System.out.println("in createNewStory");
		//map.put("fulluserstory", new CommonModel());
		ModelAndView model=new ModelAndView();
		List<Epic> epicList=new ArrayList<Epic>();
		
		if (actionButton.equals("Create new Userstory")){
			epicList= epicService.getAll();											
			model=new ModelAndView("userstory/userstoryTemplate", "commonModel", commonModel);
			model.addObject("epicList",epicList);
			//return model; 
		}

		if (actionButton.equals("Delete Selected")){
			 int [] checkedlist={68,71};

		
		/*if (actionButton.equals("Delete Selected")){ //meka hdla naaa///
			 int [] checkedlist={35,36,37,38,39,40};
			 for(int i=0;i<checkedlist.length;i++){
				 int userstoryId=checkedlist[i];
				 userstoryService.delete(userstoryId);
				 System.out.println(checkedlist[i]);
				 System.out.println("delete#######selected inside for");
			 }
			 
			 System.out.println("delete#######selected");
			
			map.put("storyList", userstoryService.getAll());
			//System.out.println(a);
			//return "index"; 
			}*/
		}
		return model;
	}
	
	@RequestMapping(value="/addnewstory",method=RequestMethod.POST)
	public ModelAndView addNewStory(CommonModel commonModel,@RequestParam String actionButton) throws IOException{
		System.out.println("in addNewStory");
		ModelAndView model=new ModelAndView();
		List<Userstory> storyList=new ArrayList<Userstory>();
		if(actionButton.equals("Save")){
			Userstory userstory=commonModel.getUserstory();
			userstory.setStatus("Pending");
			userstoryService.create(userstory);
			System.out.println("story added."); 
			model=new ModelAndView("index", "commonModel", commonModel);		
			storyList=userstoryService.getAll();
			model.addObject("storyList",storyList);
			return model;
		}
		
		else if(actionButton.equals("Save and Generate")){
			System.out.println("in Save and Generate");
			Userstory userstory=commonModel.getUserstory();
			String userstorytext=commonModel.getUserstory().getStoryname();
			ArrayList<String> entitylist=entityextractor.extractTriplets(userstorytext);
			
			if(entitylist.size()==3){
				userstory.setStatus("Generated");
				userstoryService.create(userstory);
				System.out.println("story added to userstory table.");
				int story_id=userstory.getStoryId();
				String user=entitylist.get(0);
				String predicate=entitylist.get(1);
				String object=entitylist.get(2);
				ArrayList<ArrayList<String>> testcaseArray=jenaService.jenaWithParam(user, predicate, object);
				ArrayList<String> preConditionArray = testcaseArray.get(0);
				ArrayList<String> testcases = testcaseArray.get(1);
				String preCondition=preConditionArray.get(0);
				
				Testcase t=new Testcase();
				for(int i=0;i<testcases.size();i++){
					t.setTestcase_name(testcases.get(i));
					int lastid=testcaseService.getLastid();
					t.setTestcase_id(lastid+1);
					t.setUserstory(userstory);
					t.setPre_condition(preCondition);
					t.setStatus("ready");
					testcaseService.saveTestcase(t);
				}
				
				
				List<Testcase> testcaseList= testcaseService.findTestCases(story_id);
				System.out.println("test case added");
				String userstoryname=userstory.getStoryname();
				model=new ModelAndView("testsuite/viewtestcaseforselected", "commonModel", commonModel);
				model.addObject("testcaseList",testcaseList);
				model.addObject("userstoryname", userstoryname);
				return model;
			}
			
			if(entitylist.size()!= 3){
				System.out.println("Sentence does not match with the actor, action, object concept.");
				ArrayList<String> entitylist1=entityextractor.ambiguityExtract(userstorytext);
				
				userstory.setStatus("Generated");
				userstoryService.create(userstory);
				System.out.println("story added to userstory table.");
				int story_id=userstory.getStoryId();
				String user=entitylist1.get(0);
				String predicate=entitylist1.get(1);
				String object=entitylist1.get(2);
				ArrayList<ArrayList<String>> testcaseArray=jenaService.jenaWithParam(user, predicate, object);
				ArrayList<String> preConditionArray = testcaseArray.get(0);
				ArrayList<String> testcases = testcaseArray.get(1);
				String preCondition=preConditionArray.get(0);
				
				Testcase t=new Testcase();
				for(int i=0;i<testcases.size();i++){
					t.setTestcase_name(testcases.get(i));
					int lastid=testcaseService.getLastid();
					t.setTestcase_id(lastid+1);
					t.setUserstory(userstory);
					t.setPre_condition(preCondition);
					t.setStatus("ready");
					testcaseService.saveTestcase(t);
				}
				
				List<Testcase> testcaseList= testcaseService.findTestCases(story_id);
				System.out.println("test case added");
				String userstoryname=userstory.getStoryname();
				model=new ModelAndView("testsuite/viewtestcaseforselected", "commonModel", commonModel);
				model.addObject("testcaseList",testcaseList);
				model.addObject("userstoryname", userstoryname);
				return model;
				
				
				
			}
			else{
				System.out.println("errorr");
			}
				
		}
		
		return model ;
	}
	

	@RequestMapping(value="/viewuserstory/{userstoryId}",method=RequestMethod.GET)
	public ModelAndView viewUserStory(@PathVariable("userstoryId") int userstoryId, Map<String,Object> map){
		System.out.println("in viewStory");
		System.out.println(userstoryId);
		
		CommonModel commonModel=new CommonModel();
		Userstory storyList=userstoryService.find(userstoryId);
		System.out.println(storyList);
		ModelAndView model=new ModelAndView("userstory/userstory", "commonModel", commonModel);
		model.addObject("storyList",storyList);
		return model;
		
	}
	
	@RequestMapping(value="/viewuserstory/editdeletestory/{userstoryId}",method=RequestMethod.GET)
	public ModelAndView editstory(CommonModel commonModel,@PathVariable("userstoryId") int userstoryId,@RequestParam String actionButton){
		//CommonModel commonModel=new CommonModel();
		ModelAndView model=new ModelAndView();
		Userstory userstory=userstoryService.find(userstoryId);
		if(actionButton.equals("Edit")){
			System.out.println("in edit");
			List<Epic> epicList=new ArrayList<Epic>();
			epicList= epicService.getAll();	
			//Userstory userstory=userstoryService.find(userstoryId);
			commonModel.setUserstory(userstory);
			model=new ModelAndView("userstory/edit", "commonModel", commonModel);
			model.addObject("epicList",epicList);
			model.addObject("userstory", userstory);
			return model;
		}
		
		if(actionButton.equals("Delete")){ //user story delete krnna puluwn ekta tst cases hdla nthnm wtrai//
			System.out.println("in delete");
			userstoryService.delete(userstoryId);
			System.out.println("deleted");
			model=new ModelAndView("redirect:/backtouserstory", "commonModel", commonModel);
			return model;
		}
		else if(actionButton.equals("Generate")){
			String userstorytext=userstory.getStoryname();
			ArrayList<String> entitylist=entityextractor.extractTriplets(userstorytext);
			
			if(entitylist.size()==3){
				//userstory.setStatus("Generated");
				//int story_id=userstory.getStoryId();
				String user=entitylist.get(0);
				String predicate=entitylist.get(1);
				String object=entitylist.get(2);
				ArrayList<ArrayList<String>> testcaseArray=jenaService.jenaWithParam(user, predicate, object);
				ArrayList<String> preConditionArray = testcaseArray.get(0);
				ArrayList<String> testcases = testcaseArray.get(1);
				String preCondition=preConditionArray.get(0);
				
				Testcase t=new Testcase();
				for(int i=0;i<testcases.size();i++){
					t.setTestcase_name(testcases.get(i));
					int lastid=testcaseService.getLastid();
					t.setTestcase_id(lastid+1);
					t.setUserstory(userstory);
					t.setPre_condition(preCondition);
					t.setStatus("ready");
					testcaseService.saveTestcase(t);
				}	
				
				List<Testcase> testcaseList= testcaseService.findTestCases(userstoryId);
				System.out.println("test case added");
				String userstoryname=userstory.getStoryname();
				model=new ModelAndView("testsuite/viewtestcaseforselected", "commonModel", commonModel);
				model.addObject("testcaseList",testcaseList);
				model.addObject("userstoryname", userstoryname);
				return model;
			}
			if(entitylist.size()!= 3){
				System.out.println("Sentence does not match with the actor, action, object concept.");
				ArrayList<String> entitylist1=entityextractor.ambiguityExtract(userstorytext);
				//userstory.setStatus("Generated");
				//userstoryService.create(userstory);
				//System.out.println("story added to userstory table.");
				//int story_id=userstory.getStoryId();
				String user=entitylist1.get(0);
				String predicate=entitylist1.get(1);
				String object=entitylist1.get(2);
				ArrayList<ArrayList<String>> testcaseArray=jenaService.jenaWithParam(user, predicate, object);
				ArrayList<String> preConditionArray = testcaseArray.get(0);
				ArrayList<String> testcases = testcaseArray.get(1);
				String preCondition=preConditionArray.get(0);
				
				Testcase t=new Testcase();
				for(int i=0;i<testcases.size();i++){
					t.setTestcase_name(testcases.get(i));
					int lastid=testcaseService.getLastid();
					t.setTestcase_id(lastid+1);
					t.setUserstory(userstory);
					t.setPre_condition(preCondition);
					t.setStatus("ready");
					testcaseService.saveTestcase(t);
				}
				
				List<Testcase> testcaseList= testcaseService.findTestCases(userstoryId);
				System.out.println("test case added");
				String userstoryname=userstory.getStoryname();
				model=new ModelAndView("testsuite/viewtestcaseforselected", "commonModel", commonModel);
				model.addObject("testcaseList",testcaseList);
				model.addObject("userstoryname", userstoryname);
				return model;
				
				
				
			}
			else{
				System.out.println("errorr");
			}
			
		}
		return null;
	}
	
	@RequestMapping(value="/updatestory/{userstoryId}",method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("commonModel") CommonModel commonModel, @PathVariable("userstoryId") int userstoryId,Map<String,Object> map,@RequestParam String actionButton){
		System.out.println("in update");
		System.out.println("update num"+userstoryId);		
		
		ModelAndView model=new ModelAndView();
		List<Userstory> storyList=new ArrayList<Userstory>();
		if(actionButton.equals("Save")){
			System.out.println("update-in save");
			Userstory userstory=commonModel.getUserstory();
			userstory.setStatus("Pending");
			userstory.setStoryId(userstoryId);				
			userstoryService.update(userstory);
			System.out.println("story updated."); 
			model=new ModelAndView("index", "commonModel", commonModel);		
			storyList=userstoryService.getAll();
			model.addObject("storyList",storyList);
			return model;
		}
		else if(actionButton.equals("Save and Generate")){
			System.out.println("update-in Save and Generate");
			Userstory userstory=commonModel.getUserstory();
			String userstorytext=commonModel.getUserstory().getStoryname();
			ArrayList<String> entitylist=entityextractor.extractTriplets(userstorytext);
			
			if(entitylist.size()==3){
				userstory.setStatus("Generated");
				userstory.setStoryId(userstoryId);				
				userstoryService.update(userstory);
				System.out.println("story updated.");
				//int story_id=userstory.getStoryId();
				String user=entitylist.get(0);
				String predicate=entitylist.get(1);
				String object=entitylist.get(2);
				ArrayList<ArrayList<String>> testcaseArray=jenaService.jenaWithParam(user, predicate, object);
				ArrayList<String> preConditionArray = testcaseArray.get(0);
				ArrayList<String> testcases = testcaseArray.get(1);
				String preCondition=preConditionArray.get(0);
				
				Testcase t=new Testcase();
				for(int i=0;i<testcases.size();i++){
					t.setTestcase_name(testcases.get(i));
					int lastid=testcaseService.getLastid();
					t.setTestcase_id(lastid+1);
					t.setUserstory(userstory);
					t.setPre_condition(preCondition);
					t.setStatus("ready");
					testcaseService.saveTestcase(t);
				}
				
				
				List<Testcase> testcaseList= testcaseService.findTestCases(userstoryId);
				System.out.println("test case added");
				String userstoryname=userstory.getStoryname();
				model=new ModelAndView("testsuite/viewtestcaseforselected", "commonModel", commonModel);
				model.addObject("testcaseList",testcaseList);
				model.addObject("userstoryname", userstoryname);
				return model;
			}
			
			if(entitylist.size()!= 3){
				System.out.println("Sentence does not match with the actor, action, object concept.");
				ArrayList<String> entitylist1=entityextractor.ambiguityExtract(userstorytext);
				
				userstory.setStatus("Generated");
				userstory.setStoryId(userstoryId);				
				userstoryService.update(userstory);
				System.out.println("story updated.");
				//int story_id=userstory.getStoryId();
				String user=entitylist1.get(0);
				String predicate=entitylist1.get(1);
				String object=entitylist1.get(2);
				ArrayList<ArrayList<String>> testcaseArray=jenaService.jenaWithParam(user, predicate, object);
				ArrayList<String> preConditionArray = testcaseArray.get(0);
				ArrayList<String> testcases = testcaseArray.get(1);
				String preCondition=preConditionArray.get(0);
				
				Testcase t=new Testcase();
				for(int i=0;i<testcases.size();i++){
					t.setTestcase_name(testcases.get(i));
					int lastid=testcaseService.getLastid();
					t.setTestcase_id(lastid+1);
					t.setUserstory(userstory);
					t.setPre_condition(preCondition);
					t.setStatus("ready");
					testcaseService.saveTestcase(t);
				}
				
				List<Testcase> testcaseList= testcaseService.findTestCases(userstoryId);
				System.out.println("test case added");
				String userstoryname=userstory.getStoryname();
				model=new ModelAndView("testsuite/viewtestcaseforselected", "commonModel", commonModel);
				model.addObject("testcaseList",testcaseList);
				model.addObject("userstoryname", userstoryname);
				return model;
				
				
				
			}
			else{
				System.out.println("errorr");
			}
			
			
		}
		
		return null;
	}
	
/*	@RequestMapping(value="/updatestory/editdeletestory/{userstoryId}",method=RequestMethod.GET)
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
			ArrayList<String> entitylist=entityextractor.entityEx(t);
			System.out.println("Entity List = "+entitylist);
			//have to call jena here with these entities given as itsparameters//
			map.put("storyList", userstoryService.getAll());
			map.put("entity", entitylist);
			return "userstory/entities";
			//return "redirect:/addnewstory";
		}
		return null;
	}*/
	


	@RequestMapping(value="/backtouserstory",method=RequestMethod.GET)
	public ModelAndView backbutton(Map<String,Object> map){
		//map.put("fulluserstory", new Fulluserstory());
		map.put("storyList", userstoryService.getAll());
		CommonModel commonModel=new CommonModel();
		List<Userstory> storyList=new ArrayList<Userstory>();
		storyList=userstoryService.getAll();
		ModelAndView model=new ModelAndView("index", "commonModel", commonModel);
		model.addObject("storyList",storyList);
		return model;
		
	}
	

	

	
	
	

}
