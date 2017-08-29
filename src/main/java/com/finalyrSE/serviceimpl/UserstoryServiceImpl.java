package com.finalyrSE.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalyrSE.dao.UserstoryDao;
import com.finalyrSE.model.Fulluserstory;
import com.finalyrSE.service.UserstoryService;

@Service("userstoryService")
@Transactional
public class UserstoryServiceImpl implements UserstoryService {
	
	@Autowired
	UserstoryDao userstoryDao;

	@Override
	public void create(Fulluserstory fulluserstory) {
		userstoryDao.create(fulluserstory);
		
	}

	@Override
	public void update(Fulluserstory fulluserstory) {
		userstoryDao.update(fulluserstory);
		
	}

	@Override
	public Fulluserstory edit(int userstoryId) {
		return userstoryDao.edit(userstoryId);
	}

	@Override
	public void delete(int userstoryId) {
		userstoryDao.delete(userstoryId);
		
	}

	@Override
	public Fulluserstory find(int userstoryId) {
		return userstoryDao.find(userstoryId);
	}

	@Override
	public List<Fulluserstory> getAll() {
		return userstoryDao.getAll();
	}

}
