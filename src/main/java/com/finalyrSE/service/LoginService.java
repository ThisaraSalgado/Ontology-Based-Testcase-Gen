package com.finalyrSE.service;

import com.finalyrSE.model.User;

public interface LoginService {
	
	public boolean CheckLogin(String username,String password);
	public User getUser(String username);
}
