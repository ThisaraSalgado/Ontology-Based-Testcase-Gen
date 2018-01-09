package com.finalyrSE.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.finalyrSE.model.Testcase;
import com.finalyrSE.model.Userstory;
//import com.finalyrSE.model.Testcase;
import com.finalyrSE.service.JenaTestService;
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
		List<Userstory> userstorynames= userstoryService.findUserStories(epicID);
		model=new ModelAndView("testsuite/viewuserstoryvise");
		model.addObject("userstorynames",userstorynames);
		return model;
	}
	@RequestMapping(value = "/viewtestcaseforselected",method=RequestMethod.GET)
	public String ViewTestSuite() throws IOException{
		System.out.println("In viewtestcaseforselected");
		return "testsuite/viewtestcaseforselected";
	}
	@RequestMapping(value= "/testcaseview" , method=RequestMethod.POST)
	public String Testcaseview(Map<String,Object> map,@ModelAttribute("testcase") Testcase testcase) throws IOException{
		System.out.println("In testcaseview");
		//@ModelAttribute("testcase") Testcase testcase;
		map.put("testcase", new Testcase());
		return "testsuite/testcaseView";
	}
/*
	@RequestMapping(value="/upadatetestcase", method=RequestMethod.POST)
	public String updatetestcase(Map<String,Object> map,@ModelAttribute("testcase") Testcase testcase) throws IOException{
		System.out.println("in update testcase");
		//testcaseService.update(testcase);
		return "testsuite/viewtestcaseforselected";
	}
	*/
}
