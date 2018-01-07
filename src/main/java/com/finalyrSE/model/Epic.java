package com.finalyrSE.model;


import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Epic {
	
	private int Epic_ID;
	private String epicname;
	
	private Set<Userstory> story = new HashSet<Userstory>(0);
		
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "epic")
	public Set<Userstory> getStory() {
		return story;
	}

	public void setStory(Set<Userstory> story) {
		this.story = story;
	}

	public Epic(){}
	
	public Epic(String epicname, Set<Userstory> story){
		this.epicname = epicname;
		this.story = story;
	}
	@Id
    @GeneratedValue
    @Column(name = "Epic_ID")
	public int getEpic_ID() {
		return Epic_ID;
	}
	
	public void setEpic_ID(int Epic_ID) {
		this.Epic_ID = Epic_ID;
	}
	
	public String getEpicname() {
		return epicname;
	}
	public void setEpicname(String epicname) {
		this.epicname = epicname;
	}
	
	




}
