package com.finalyrSE.serviceimpl;

import java.util.List;

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

	@Override
	public List<Testcase> findTestCases(int storyId) {
		
		// TODO Auto-generated method stub
		return testcaseDao.findTestCases(storyId);
	}

	@Override
	public Testcase find(int testcase_id) {
		// TODO Auto-generated method stub
		return testcaseDao.find(testcase_id);
	}

	@Override
	public void update(Testcase testcase) {
		testcaseDao.update(testcase);
		
	}

	@Override
	public void delete(int testcase_id) {
		testcaseDao.delete(testcase_id);
		
	}

}
