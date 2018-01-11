package com.finalyrSE.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Testcase {
	
	private int testcase_id;
	private String testcase_name;
	private String pre_condition;
	private String expected_result;
	private String status;
	private String approveby;
	
	private Userstory userstory;
	
	public Testcase(){}
	
	public Testcase(String testcasename, String precondition, String result, String status,String approvedby, Userstory userstory ){
		this.testcase_name = testcasename;
		this.pre_condition = precondition;
		this.expected_result = result;
		this.status= status;
		this.approveby = approvedby;
		this.userstory = userstory;
	}
	
	@Id
	@Column(name="TestCase_ID")
	public int getTestcase_id() {
		return testcase_id;
	}

	public void setTestcase_id(int testcase_id) {
		this.testcase_id = testcase_id;
	}

	public String getTestcase_name() {
		return testcase_name;
	}

	public void setTestcase_name(String testcase_name) {
		this.testcase_name = testcase_name;
	}

	public String getPre_condition() {
		return pre_condition;
	}

	public void setPre_condition(String pre_condition) {
		this.pre_condition = pre_condition;
	}

	public String getExpected_result() {
		return expected_result;
	}

	public void setExpected_result(String expected_result) {
		this.expected_result = expected_result;
	}
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getApproveby() {
		return approveby;
	}

	public void setApproveby(String approveby) {
		this.approveby = approveby;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Story_ID", nullable = false)
	public Userstory getUserstory() {
		return userstory;
	}

	public void setUserstory(Userstory userstory) {
		this.userstory = userstory;
	}
}
