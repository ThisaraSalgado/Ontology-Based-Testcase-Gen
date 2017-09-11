package com.finalyrSE.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestcaseController {
	
	@RequestMapping(value = "/testhome")
	public String ViewTestHome(){
		return "testsuite/testhome";
	}

	@RequestMapping(value = "/testcase")
	public String CreateTestCase(){
		return "testsuite/testcase";
	}
}
