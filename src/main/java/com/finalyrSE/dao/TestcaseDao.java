package com.finalyrSE.dao;

import java.util.List;

import com.finalyrSE.model.Testcase;

public interface TestcaseDao {
	public void saveTestcase(Testcase testcase);
	public int getLastid();
	public List<Testcase> findTestCases(int storyId);
	public Testcase find(int testcase_id);
}
