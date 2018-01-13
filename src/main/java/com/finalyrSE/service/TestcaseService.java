package com.finalyrSE.service;

import java.util.List;

import com.finalyrSE.model.Testcase;

public interface TestcaseService {
	public void saveTestcase(Testcase testcase);
	public int getLastid();
	public List <Testcase> findTestCases(int storyId);
	public Testcase find(int testcase_id);
	public void update(Testcase testcase);
	public void delete(int testcase_id);
}
