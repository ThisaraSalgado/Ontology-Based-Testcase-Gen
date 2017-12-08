package com.finalyrSE.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.finalyrSE.service.JenaTestService;

@Controller
public class TestcaseController {
	
	@Autowired
	JenaTestService jenatest;
	
	
	@RequestMapping(value = "/testhome",method=RequestMethod.GET)
	public String ViewTestHome() throws IOException{
		System.out.println("in jena test");
		/*if(actionButton.equals("Local Retrieval")){
			System.out.println("action button called");
			map.put("result", jenatest.testJena());
		}*/
		return "testsuite/testhome";
	}
	@RequestMapping(value = "/jenatest",method=RequestMethod.GET)
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
	
	@RequestMapping(value = "/tempview",method=RequestMethod.GET)
	public String ViewTempTestSuite() throws IOException{
		System.out.println("In temp view");
		return "testsuite/tempview";
	}
}
