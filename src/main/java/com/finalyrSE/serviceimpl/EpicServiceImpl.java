package com.finalyrSE.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalyrSE.dao.EpicDao;
import com.finalyrSE.model.Epic;
import com.finalyrSE.service.EpicService;

@Service("epicService")
@Transactional
public class EpicServiceImpl implements EpicService {
	
	@Autowired
	EpicDao epicDao;

	@Override
	public Epic find(int epicId) {
		return epicDao.find(epicId);
	}

	@Override
	public List<Epic> getAll() {
		
		return epicDao.getAll();
	}

}
