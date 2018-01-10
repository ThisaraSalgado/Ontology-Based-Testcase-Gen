package com.finalyrSE.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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

	@Override
	public List<Userstory> findUserStories(int epicId) {
		// TODO Auto-generated method stub
		//return currentSession().get(Userstory.class, epicId);
		
		String hql1= "FROM Userstory WHERE Epic_ID=";
		String hql2= Integer.toString(epicId) ;
		String hql= hql1+hql2;
		System.out.println(hql);
		Query query = currentSession().createQuery(hql);
		System.out.println(query);
		List<Userstory> results = query.list();
		System.out.println("#################"+results);
		return results;
		
		/*
		System.out.println(epicId);
		Criteria cr = currentSession().createCriteria(Userstory.class, "u")
		.add(Restrictions.eq("storyId", 81));
		/*.createAlias("u.epic","epic")
		//.add(Restrictions.eq("e.Epic_ID", epicId));
		.add(Restrictions.eq("epic.Epic_ID", epicId));
		//
		List<Userstory> results = cr.list();
		System.out.println(results);
		return results;
		*/
	}
	

}
