package com.finalyrSE.model;

import java.util.List;
import java.util.Map;

public class CommonModel {
	private Epic epic;
	private Fulluserstory fulluserstory;
	private Userstory userstory;
	private User user;
	private List<String> epicNameList;
	Map<String,String> epicList;
	private Testcase testcase;
	
	
	public Testcase getTestcase() {
		return testcase;
	}
	public void setTestcase(Testcase testcase) {
		this.testcase = testcase;
	}
	public Map<String, String> getEpicList() {
		return epicList;
	}
	public void setEpicList(Map<String, String> epicList) {
		this.epicList = epicList;
	}
	
	public List<String> getEpicNameList() {
		return epicNameList;
	}
	public void setEpicNameList(List<String> epicNameList) {
		this.epicNameList = epicNameList;
	}
	public Epic getEpic() {
		return epic;
	}
	public void setEpic(Epic epic) {
		this.epic = epic;
	}
	public Fulluserstory getFulluserstory() {
		return fulluserstory;
	}
	public void setFulluserstory(Fulluserstory fulluserstory) {
		this.fulluserstory = fulluserstory;
	}
	public Userstory getUserstory() {
		return userstory;
	}
	public void setUserstory(Userstory userstory) {
		this.userstory = userstory;
	}
	public User getUser() {
		return user;
	}
	public User getUser(String username){
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
