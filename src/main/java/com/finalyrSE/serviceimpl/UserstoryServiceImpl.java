package com.finalyrSE.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalyrSE.dao.UserstoryDao;
import com.finalyrSE.model.CommonModel;
import com.finalyrSE.model.Fulluserstory;
import com.finalyrSE.model.Userstory;
import com.finalyrSE.service.UserstoryService;

@Service("userstoryService")
@Transactional
public class UserstoryServiceImpl implements UserstoryService {
	
	@Autowired
	UserstoryDao userstoryDao;

	@Override
	public void create(Userstory userstory) {
		userstoryDao.create(userstory);
		
	}

	@Override
	public void update(Userstory userstory) {
		userstoryDao.update(userstory);
		
	}

	@Override
	public Userstory edit(int userstoryId) {
		return userstoryDao.edit(userstoryId);
	}

	@Override
	public void delete(int userstoryId) {
		userstoryDao.delete(userstoryId);
		
	}

	@Override
	public Userstory find(int userstoryId) {
		return userstoryDao.find(userstoryId);
	}

	@Override
	public List<Userstory> getAll() {
		return userstoryDao.getAll();
	}

	@Override
	public void create(CommonModel commonModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Userstory> findUserStories(int epicId) {
		// TODO Auto-generated method stub
		return userstoryDao.findUserStories(epicId);
	}

}
