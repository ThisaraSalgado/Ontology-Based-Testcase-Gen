package com.finalyrSE.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalyrSE.dao.LoginDao;
import com.finalyrSE.model.User;
import com.finalyrSE.service.LoginService;

@Service("loginservice")
@Transactional
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginDao loginDao;

	@Override
	public boolean CheckLogin(String username, String password) {
		return loginDao.Checklogin(username, password);
		
	}

	@Override
	public User getUser(String username) {
		return loginDao.getUser(username);
	}

	

}
