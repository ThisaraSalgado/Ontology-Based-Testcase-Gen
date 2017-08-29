package com.finalyrSE.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Fulluserstory {
	
	@Id
	@GeneratedValue
	private int userstoryId;
	private String userstoryname;
	private String assignee;
	private String status;
	private String priority;
	private String prerequisites;
	private String narratives;
	private String acceptancecriteria;
	private String startdate;
	private String duedate;
	
	
	public int getUserstoryId() {
		return userstoryId;
	}
	public void setUserstoryId(int userstoryId) {
		this.userstoryId = userstoryId;
	}
	public String getUserstoryname() {
		return userstoryname;
	}
	public void setUserstoryname(String userstoryname) {
		this.userstoryname = userstoryname;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getPrerequisites() {
		return prerequisites;
	}
	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}
	public String getNarratives() {
		return narratives;
	}
	public void setNarratives(String narratives) {
		this.narratives = narratives;
	}
	public String getAcceptancecriteria() {
		return acceptancecriteria;
	}
	public void setAcceptancecriteria(String acceptancecriteria) {
		this.acceptancecriteria = acceptancecriteria;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	
	
}
