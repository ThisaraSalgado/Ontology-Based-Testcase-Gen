package com.finalyrSE.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.hibernate.mapping.Array;

public interface EntityExtractionService {
	public ArrayList<ArrayList<String>> entityEx(ArrayList<String>  textlist) throws FileNotFoundException, IOException;
	public ArrayList<String> sentenceTokenize(String userstorytext);
	public ArrayList<String> extractEntity(String userstory);
	public String splitSentence(String text);
	public ArrayList<String> extrachNounVerbs(String text);

}
