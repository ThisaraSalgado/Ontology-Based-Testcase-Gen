package com.finalyrSE.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import com.finalyrSE.model.Testcase;
import com.finalyrSE.service.JenaTestService;
//import com.finalyrSE.service.TestcaseService;

@Controller
public class TestcaseController {
	
	@Autowired
	JenaTestService jenatest;
	/*
	@Autowired
	TestcaseService testcaseService;
	*/
	
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
	
	@RequestMapping(value = "/testsuiteview",method=RequestMethod.GET)
	public String ViewEpicList() throws IOException{
		System.out.println("In testsuiteview");
		return "testsuite/testsuiteview";
	}
	@RequestMapping(value = "/viewuserstoryvise",method=RequestMethod.GET)
	public String ViewUserStory() throws IOException{
		System.out.println("In viewuserstoryvise");
		return "testsuite/viewuserstoryvise";
	}
	@RequestMapping(value = "/viewtestcaseforselected",method=RequestMethod.GET)
	public String ViewTestSuite() throws IOException{
		System.out.println("In viewtestcaseforselected");
		return "testsuite/viewtestcaseforselected";
	}
	@RequestMapping(value= "/testcaseview" , method=RequestMethod.POST)
	public String Testcaseview(Map<String,Object> map) throws IOException{
		System.out.println("In testcaseview");
		//@ModelAttribute("testcase") Testcase testcase
		//map.put("testcase", new Testcase());
		return "testsuite/testcaseview";
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
