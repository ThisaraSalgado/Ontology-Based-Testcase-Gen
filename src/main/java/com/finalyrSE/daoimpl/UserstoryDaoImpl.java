package com.finalyrSE.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.finalyrSE.dao.UserstoryDao;
import com.finalyrSE.model.Fulluserstory;

@Repository("userstoryDao")
public class UserstoryDaoImpl implements UserstoryDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(Fulluserstory fulluserstory) {
		currentSession().save(fulluserstory);
		
	}

	@Override
	public void update(Fulluserstory fulluserstory) {
		currentSession().update(fulluserstory);
		
	}

	@Override
	public Fulluserstory edit(int userstoryId) {
		return find(userstoryId);
	}

	@Override
	public void delete(int userstoryId) {
		currentSession().delete(userstoryId);
		
	}

	@Override
	public Fulluserstory find(int userstoryId) {
		return currentSession().get(Fulluserstory.class, userstoryId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fulluserstory> getAll() {
		//System.out.println("get all called");
		return currentSession().createCriteria(Fulluserstory.class).list();
		
		
	}
	

}
