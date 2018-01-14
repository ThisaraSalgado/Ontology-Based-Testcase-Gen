package com.finalyrSE.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.finalyrSE.model.CommonModel;
import com.finalyrSE.model.Epic;
import com.finalyrSE.model.Testcase;
import com.finalyrSE.model.Userstory;
//import com.finalyrSE.model.Testcase;
import com.finalyrSE.service.JenaTestService;
import com.finalyrSE.service.TestcaseService;
import com.finalyrSE.service.UserstoryService;
//import com.finalyrSE.service.TestcaseService;
import com.finalyrSE.service.EpicService;

@Controller
public class TestcaseController {
	
	@Autowired
	JenaTestService jenatest;
	@Autowired
	EpicService epicService;
	
	
	@Autowired
	UserstoryService userstoryService;
	
	@Autowired
	TestcaseService testcaseService;
	
	
	@RequestMapping(value = "/testhome",method=RequestMethod.GET)
	public String ViewTestHome() throws IOException{
		System.out.println("in jena test");
		/*if(actionButton.equals("Local Retrieval")){
			System.out.println("action button called");
			map.put("result", jenatest.testJena());
		}*/
		return "testsuite/testhome";
	}
	@RequestMapping(value = "/jenatest",method=RequestMethod.POST)
	public String ViewJenaTest(Map<String,Object> map,@RequestParam String actionButton) throws IOException{
		System.out.println("in jena test loacal");
		if(actionButton.equals("Local Retrieval")){
			System.out.println("action button called");
			map.put("result", jenatest.testJena());
		}
		return "testsuite/testhome";
	}
	
	@RequestMapping(value = "/testcase")
	public String CreateTestCase(){
		return "testsuite/testcase";
	}
	
	@RequestMapping(value = "/tempview",method=RequestMethod.POST)
	public String ViewTempTestSuite() throws IOException{
		System.out.println("In temp view");
		return "testsuite/tempview";
	}
	//////////////////////////////////////////////////////////
	
	
	@RequestMapping(value = "/testsuiteview",method=RequestMethod.GET)
	public ModelAndView ViewEpicList(@ModelAttribute("commonModel") CommonModel commonModel) throws IOException{
		System.out.println("In testsuiteview");
		ModelAndView model=new ModelAndView();
		List<Epic> epicList=new ArrayList<Epic>();
		epicList= epicService.getAll();
		model=new ModelAndView("testsuite/testsuiteview");
		model.addObject("epicList",epicList);	
		return model;
	}
	
	@RequestMapping(value = "/viewuserstoryvise/{epicID}",method=RequestMethod.GET)
	public ModelAndView ViewUserStory(@PathVariable("epicID") int epicID) throws IOException{
		System.out.println("In viewuserstoryvise");
		System.out.println(epicID);
		ModelAndView model= new ModelAndView();
		List<Userstory> userstory= userstoryService.findUserStories(epicID);
		//System.out.println("///////////////////////////"+userstory);
		model=new ModelAndView("testsuite/viewuserstoryvise");
		model.addObject("userstory",userstory);
		return model;
	}
	@RequestMapping(value = "/viewtestcaseforselected/{storyId}",method=RequestMethod.GET)
	public ModelAndView ViewTestSuite(@ModelAttribute("commonModel") CommonModel commonModel,@PathVariable("storyId") int storyId) throws IOException{
		System.out.println("In viewtestcaseforselected");
		System.out.println(storyId);
		ModelAndView model= new ModelAndView();
		List<Testcase> testcaseList= testcaseService.findTestCases(storyId);
		Userstory userstory=userstoryService.find(storyId);
		String userstoryname=userstory.getStoryname();
		model=new ModelAndView("testsuite/viewtestcaseforselected", "commonModel", commonModel);
		model.addObject("testcaseList",testcaseList);
		model.addObject("userstoryname", userstoryname);
		return model;
	}

	@RequestMapping(value= "/testcaseview/{testcase_id}" , method=RequestMethod.GET)
	public ModelAndView Testcaseview(@PathVariable("testcase_id") int testcase_id,HttpServletRequest request) throws IOException{
		System.out.println("In testcaseview");
		System.out.println(testcase_id);
		//Testcase testcaseModel=new Testcase();
		Testcase testcase = testcaseService.find(testcase_id);
		System.out.println("@@@@@@@@@@@@@@@@@"+testcase);
		HttpSession session = request.getSession();
		System.out.println("========"+session.getAttribute("role"));
		if(session.getAttribute("role").equals("lead")){
			System.out.println("role lead");
			ModelAndView model= new ModelAndView("testsuite/testcaseLead");
			model.addObject("testcase", testcase);
			return model;
			
		}else{
			ModelAndView model= new ModelAndView("testsuite/testcase");
			model.addObject("testcase", testcase);
			return model;
		}
		
	}
	
	@RequestMapping(value= "/testcaseview/editdeletetestcase/{testcase_id}" , method=RequestMethod.GET)
	public ModelAndView Edittestcase(@ModelAttribute("commonModel") CommonModel commonModel,@PathVariable("testcase_id") int testcase_id,@RequestParam String actionButton) throws IOException{
		System.out.println("In testcaseview/editdeletetestcase");
		System.out.println(testcase_id);
		if(actionButton.equals("Edit")){
			System.out.println("in edit");
			Testcase testcase= testcaseService.find(testcase_id); 
			commonModel.setTestcase(testcase);
			ModelAndView model= new ModelAndView("testsuite/testcaseView","commonModel", commonModel);
			model.addObject("testcase", testcase);
			return model;
		}
		else if(actionButton.equals("Delete")){
			System.out.println("in delete");
			Testcase testcase= testcaseService.find(testcase_id);
			int storyId=testcase.getUserstory().getStoryId();
			System.out.println(storyId+" delted story id of tid");
			testcaseService.delete(testcase_id);
			System.out.println("deleted");
			
			ModelAndView model= new ModelAndView();
			List<Testcase> testcaseList= testcaseService.findTestCases(storyId);
			Userstory userstory=userstoryService.find(storyId);
			String userstoryname=userstory.getStoryname();
			model=new ModelAndView("testsuite/viewtestcaseforselected", "commonModel", commonModel);
			model.addObject("testcaseList",testcaseList);
			model.addObject("userstoryname", userstoryname);
			return model;
			
		}
		
		else if(actionButton.equals("Send For Approve")){
			System.out.println("in Send For Approve");
			Testcase testcase= testcaseService.find(testcase_id); 
			testcase.setStatus("Pending");
			testcaseService.update(testcase);
			System.out.println(testcase.getStatus());	
			
			int storyId=testcase.getUserstory().getStoryId();
			ModelAndView model= new ModelAndView();
			List<Testcase> testcaseList= testcaseService.findTestCases(storyId);
			Userstory userstory=userstoryService.find(storyId);
			String userstoryname=userstory.getStoryname();
			model=new ModelAndView("testsuite/viewtestcaseforselected", "commonModel", commonModel);
			model.addObject("testcaseList",testcaseList);
			model.addObject("userstoryname", userstoryname);
			return model;
		}
		else if(actionButton.equals("Approve")){
			System.out.println("Approve");
			Testcase testcase= testcaseService.find(testcase_id); 
			testcase.setStatus("Approved");
			testcaseService.update(testcase);
			System.out.println(testcase.getStatus());	
			
			int storyId=testcase.getUserstory().getStoryId();
			ModelAndView model= new ModelAndView();
			List<Testcase> testcaseList= testcaseService.findTestCases(storyId);
			Userstory userstory=userstoryService.find(storyId);
			String userstoryname=userstory.getStoryname();
			model=new ModelAndView("testsuite/viewtestcaseforselected", "commonModel", commonModel);
			model.addObject("testcaseList",testcaseList);
			model.addObject("userstoryname", userstoryname);
			return model;
		}
		return null;
	}
	
	
	@RequestMapping(value="/updatetestcase/{testcase_id}", method=RequestMethod.POST)
	public ModelAndView updatetestcase(@ModelAttribute("commonModel") CommonModel commonModel, @PathVariable ("testcase_id") int testcase_id,HttpServletRequest request) throws IOException{
		System.out.println("in update testcase");
		System.out.println("update num "+testcase_id);
		Testcase testcase_reslts=commonModel.getTestcase(); // this is to get the bounded rslts from the testcaseview jsp
		Testcase test=testcaseService.find(testcase_id); //this is to get the story id from test object
		Userstory userstory=test.getUserstory();
		testcase_reslts.setUserstory(userstory);
		commonModel.setTestcase(testcase_reslts);
		testcaseService.update(testcase_reslts);
		System.out.println("updated table");
		HttpSession session = request.getSession();
		if(session.getAttribute("role").equals("lead")){
			Testcase testcase=testcaseService.find(testcase_id); //after updating the table get testcase detials
			ModelAndView model= new ModelAndView("testsuite/testcaseLead","commonModel", commonModel);
			model.addObject("testcase", testcase);
			return model;
		}else{
			Testcase testcase=testcaseService.find(testcase_id); //after updating the table get testcase detials
			ModelAndView model= new ModelAndView("testsuite/testcase","commonModel", commonModel);
			model.addObject("testcase", testcase);
			return model;
		}
		
		
	}
	
	@RequestMapping(value="/updatetestcase/editdeletetestcase/{testcase_id}", method=RequestMethod.GET)
	public ModelAndView editUpdatedtestcases(@ModelAttribute("commonModel") CommonModel commonModel, @PathVariable ("testcase_id") int testcase_id,@RequestParam String actionButton ) throws IOException{
		System.out.println(testcase_id);
		if(actionButton.equals("Edit")){
			System.out.println("in edittt");
			Testcase testcase= testcaseService.find(testcase_id); 
			commonModel.setTestcase(testcase);
			ModelAndView model= new ModelAndView("testsuite/testcaseView","commonModel", commonModel);
			model.addObject("testcase", testcase);
			return model;
		}
		if(actionButton.equals("Delete")){
			System.out.println("in deleteeee");
			Testcase testcase= testcaseService.find(testcase_id);
			int storyId=testcase.getUserstory().getStoryId();
			System.out.println(storyId+" delted story id of tid");
			testcaseService.delete(testcase_id);
			System.out.println("deleted");
			
			ModelAndView model= new ModelAndView();
			List<Testcase> testcaseList= testcaseService.findTestCases(storyId);
			Userstory userstory=userstoryService.find(storyId);
			String userstoryname=userstory.getStoryname();
			model=new ModelAndView("testsuite/viewtestcaseforselected", "commonModel", commonModel);
			model.addObject("testcaseList",testcaseList);
			model.addObject("userstoryname", userstoryname);
			return model;
		}
		
		
		
		return null;
		
	}
	@RequestMapping(value="/addnew/{storyId}", method=RequestMethod.POST)
	public ModelAndView addNew(@ModelAttribute("commonModel") CommonModel commonModel, @PathVariable ("storyId") int storyId )throws IOException{
		System.out.println("add new");
		System.out.println(storyId);
		Userstory userstory= userstoryService.find(storyId);
		commonModel.setUserstory(userstory);
		ModelAndView model= new ModelAndView();
		model=new ModelAndView("testsuite/addnew", "commonModel", commonModel);
		model.addObject("userstory", userstory);
		return model;
	}
	
	@RequestMapping(value="/saveadded/{storyId}", method=RequestMethod.POST)
	public ModelAndView saveNew(@ModelAttribute("commonModel") CommonModel commonModel, @PathVariable ("storyId") int storyId )throws IOException{
		System.out.println("save add new");
		//Userstory userstory= commonModel.getUserstory();
		System.out.println(storyId);
		Testcase testcase=commonModel.getTestcase();
		int id=testcaseService.getLastid();
		System.out.println(id+" id");
		testcase.setTestcase_id(id+1);
		Userstory userstory= userstoryService.find(storyId);
		testcase.setUserstory(userstory);
		commonModel.setTestcase(testcase);
		testcase.setStatus("ready");
		testcaseService.saveTestcase(testcase);

		ModelAndView model= new ModelAndView();
		List<Testcase> testcaseList= testcaseService.findTestCases(storyId);
		String userstoryname=userstory.getStoryname();
		model=new ModelAndView("testsuite/viewtestcaseforselected", "commonModel", commonModel);
		model.addObject("testcaseList",testcaseList);
		model.addObject("userstoryname", userstoryname);
		return model;
		
	}
	
}
