package com.finalyrSE.daoimpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finalyrSE.dao.EpicDao;
import com.finalyrSE.model.Epic;

@Repository("epicDao")
public class EpicDaoImpl implements EpicDao{
	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Epic find(int epicId) {
		return currentSession().get(Epic.class, epicId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Epic> getAll() {
		return (List<Epic>) currentSession().createCriteria(Epic.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map> getEpicnames() {
		
		System.out.println("awa");
		return (List<Map>) currentSession().createCriteria(Epic.class).list();
	}

	


}
