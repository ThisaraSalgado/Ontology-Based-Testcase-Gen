package com.finalyrSE.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.finalyrSE.dao.UserstoryDao;
import com.finalyrSE.model.Fulluserstory;
import com.finalyrSE.model.Userstory;

@Repository("userstoryDao")
public class UserstoryDaoImpl implements UserstoryDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(Userstory userstory) {
		currentSession().save(userstory);
		
	}

	@Override
	public void update(Userstory userstory) {
		currentSession().update(userstory);
		
	}

	@Override
	public Userstory edit(int userstoryId) {
		return find(userstoryId);
	}

	@Override
	public void delete(int userstoryId) {
		Fulluserstory fulluserstory=new Fulluserstory();
		fulluserstory.setUserstoryId(userstoryId);
		currentSession().delete(fulluserstory);
		
	}

	@Override
	public Userstory find(int userstoryId) {
		return currentSession().get(Userstory.class, userstoryId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Userstory> getAll() {
		//System.out.println("get all called");
		return (List<Userstory>) currentSession().createCriteria(Userstory.class).list();
		
	}
	

}
