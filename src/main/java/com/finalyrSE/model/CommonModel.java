package com.finalyrSE.model;


public class CommonModel {
	private Epic epic;
	private Fulluserstory fulluserstory;
	private Userstory userstory;
	private User user;
	private Testcase testcase;
	private String message;
	private String msgType;
	
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Testcase getTestcase() {
		return testcase;
	}
	public void setTestcase(Testcase testcase) {
		this.testcase = testcase;
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
