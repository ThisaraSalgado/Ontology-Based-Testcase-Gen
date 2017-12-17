package com.finalyrSE.service;

import java.util.ArrayList;

public interface JenaTestService {
	
	public String testJena();
	public String jenaWithParam(String actor, String action, String object);
	public ArrayList<String> checkImplicits(String actor, String action);
	public ArrayList<String> getDataProperties(String actor,ArrayList<String> actions,String object);
}
