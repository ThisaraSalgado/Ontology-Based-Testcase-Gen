package com.finalyrSE.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.hibernate.mapping.Array;

public interface EntityExtractionService {

	public ArrayList<String> extractTriplets(String text) ; 
	public String preProcess(String text);
	public ArrayList<String> ambiguityExtract(String text);

}
