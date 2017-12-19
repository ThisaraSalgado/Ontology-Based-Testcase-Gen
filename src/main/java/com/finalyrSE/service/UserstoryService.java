package com.finalyrSE.service;

import java.util.List;

import com.finalyrSE.model.CommonModel;
import com.finalyrSE.model.Fulluserstory;
import com.finalyrSE.model.Userstory;

public interface UserstoryService {
	public void create(Userstory userstory);
	public void update(Userstory userstory);
	public Userstory edit(int userstoryId);
	public void delete(int userstoryId);
	public Userstory find(int userstoryId);
	public List<Userstory> getAll();
	public void create(CommonModel commonModel);
	
}
