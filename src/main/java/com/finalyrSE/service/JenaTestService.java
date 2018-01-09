package com.finalyrSE.service;

import java.util.ArrayList;

public interface JenaTestService {
	
	public String testJena();
	public String jenaWithParam(String actor, String action, String object);
	public ArrayList<String> checkImplicits(String actor, String action);
	public ArrayList<String> getObjectDataProperties(String actor, String action, String object);
	public ArrayList<String> getActionDataProperties(String actor,ArrayList<String> actions);
	public String checkActor(String actor, String action);
	public String findSubclass(String action);
	public ArrayList<String> findPrecondition(String action);
}
