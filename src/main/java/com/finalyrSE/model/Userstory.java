package com.finalyrSE.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Userstory {
	@Id
	@GeneratedValue
	private int storyId;
	private String storyname;
	private String assignee;
	private String status;
	private String priority;
	private String prerequites;
	private String narratives;
	private String acceptancecritirea;
	private String startdate;
	private String duedate;
/*	
	@ManyToOne
	@Column(name ="Epic_ID")
	private Set<Epic> epicid;*/
	
	private Epic epic;
	
	public Userstory(){
		
	}
	
	public Userstory(String storyname,String assignee,String status,String priority,String prerequites,
			String narratives,String acceptancecritirea,String startdate,String duedate,Epic epic){
		
		this.storyname=storyname;
		this.assignee=assignee;
		this.status=status;
		this.priority=priority;
		this.prerequites=prerequites;
		this.narratives=narratives;
		this.acceptancecritirea=acceptancecritirea;
		this.startdate=startdate;
		this.duedate=duedate;
		this.epic = epic;
	}
	
	@Id
    @Column(name = "Story_ID")
    @GeneratedValue
	public int getStoryId() {
		return storyId;
	}
	public void setStoryId(int storyId) {
		this.storyId = storyId;
	}
	public String getStoryname() {
		return storyname;
	}
	public void setStoryname(String storyname) {
		this.storyname = storyname;
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
	public String getPrerequites() {
		return prerequites;
	}
	public void setPrerequites(String prerequites) {
		this.prerequites = prerequites;
	}
	public String getNarratives() {
		return narratives;
	}
	public void setNarratives(String narratives) {
		this.narratives = narratives;
	}
	public String getAcceptancecritirea() {
		return acceptancecritirea;
	}
	public void setAcceptancecritirea(String acceptancecritirea) {
		this.acceptancecritirea = acceptancecritirea;
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Epic_ID", nullable = false)
	public Epic getEpic() {
		return epic;
	}
	public void setEpic(Epic epic) {
		this.epic = epic;
	}
}