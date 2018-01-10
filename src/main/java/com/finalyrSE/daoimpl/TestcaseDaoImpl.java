package com.finalyrSE.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finalyrSE.dao.TestcaseDao;
import com.finalyrSE.model.Testcase;
import com.finalyrSE.model.Userstory;

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

	@Override
	public List<Testcase> findTestCases(int storyId) {
		// TODO Auto-generated method stub
		String hql1="FROM Testcase WHERE Story_ID=";
		String hql2= Integer.toString(storyId) ;
		String hql = hql1+hql2;
		System.out.println(hql);
		Query query = currentSession().createQuery(hql);
		System.out.println(query);
		List<Testcase> results = query.list();
		System.out.println("$$$$$$$$$$$$$$$$$$"+results);
		return results;
	}

	@Override
	public Testcase find(int testcase_id) {
		// TODO Auto-generated method stub
		return currentSession().get(Testcase.class, testcase_id);
	}

}
