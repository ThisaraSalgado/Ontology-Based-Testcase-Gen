package com.finalyrSE.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finalyrSE.dao.TestcaseDao;
import com.finalyrSE.model.Testcase;

@Repository("testcaseDao")
public class TestcaseDaoImpl implements TestcaseDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void saveTestcase(Testcase testcase) {
		currentSession().save(testcase);
		
	}

	@Override
	public int getLastid() {
		String hql= "select max(testcase_id) from Testcase"; 
		List list = currentSession().createQuery(hql).list(); 
		int maxID = ( (Integer)list.get(0) ).intValue(); 
		//System.out.println("maxID === "+maxID);
		return maxID;
	}

}
