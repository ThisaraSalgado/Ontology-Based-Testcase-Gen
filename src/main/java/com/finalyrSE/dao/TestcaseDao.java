package com.finalyrSE.dao;

import com.finalyrSE.model.Testcase;

public interface TestcaseDao {
	public void saveTestcase(Testcase testcase);
	public int getLastid();
}
