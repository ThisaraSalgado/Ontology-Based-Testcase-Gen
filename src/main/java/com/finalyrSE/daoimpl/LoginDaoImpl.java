package com.finalyrSE.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finalyrSE.dao.LoginDao;
import com.finalyrSE.model.Testcase;
import com.finalyrSE.model.User;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean Checklogin(String username, String password) {
		//System.out.println("in loginDaoImpl");
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		//Query using Hibernate Query Language
		String SQL_QUERY =" from User as o where o.username=? and o.password=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0,username);
		query.setParameter(1,password);
		List list = query.list();

		if ((list != null) && (list.size() > 0)) {
			userFound= true;
		}
		session.close();
		return userFound; 
		
	}

	@Override
	public User getUser(String username) {
		Session session = sessionFactory.openSession();
		String SQL_QUERY ="from User as o where o.username=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0, username);
		List<User> results = query.list();
		return results.get(0);
	}

	

}
