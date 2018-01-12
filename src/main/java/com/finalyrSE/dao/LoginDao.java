package com.finalyrSE.dao;

import com.finalyrSE.model.User;

public interface LoginDao {
	
	public boolean Checklogin(String username, String password);
	public User getUser(String username);

}
