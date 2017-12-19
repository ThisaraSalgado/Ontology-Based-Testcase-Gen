package com.finalyrSE.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Epic {
	
	private int epic_id;
	private String epicname;
	
	public Epic(){}
	
	public Epic(String epicname){
		this.epicname=epicname;
	}
	
	@Id
    @Column(name = "Epic_ID")
    @GeneratedValue
	public int getEpic_id() {
		return epic_id;
	}
	public void setEpic_id(int epic_id) {
		this.epic_id = epic_id;
	}
	public String getEpicname() {
		return epicname;
	}
	public void setEpicname(String epicname) {
		this.epicname = epicname;
	}
		
	private Set<Userstory> userstorys;
	
	@OneToMany(mappedBy = "epic", cascade = CascadeType.ALL)
	public Set<Userstory> getUserstorys() {
		return userstorys;
	}

	public void setUserstorys(Set<Userstory> userstorys) {
		this.userstorys = userstorys;
	}




}
