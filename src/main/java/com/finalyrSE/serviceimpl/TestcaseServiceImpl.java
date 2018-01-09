package com.finalyrSE.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalyrSE.dao.TestcaseDao;
import com.finalyrSE.model.Testcase;
import com.finalyrSE.service.TestcaseService;

@Service("testcaseService")
@Transactional
public class TestcaseServiceImpl implements TestcaseService{
	
	@Autowired
	TestcaseDao testcaseDao;

	@Override
	public void saveTestcase(Testcase testcase) {
		testcaseDao.saveTestcase(testcase);
		
	}

	@Override
	public int getLastid() {
		return testcaseDao.getLastid();
	}

}
