package com.finalyrSE.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface EntityExtractionService {
	public ArrayList<String> entityEx(String text) throws FileNotFoundException, IOException;

}
