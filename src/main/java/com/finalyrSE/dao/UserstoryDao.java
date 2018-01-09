package com.finalyrSE.dao;

import java.util.List;

import com.finalyrSE.model.Fulluserstory;
import com.finalyrSE.model.Userstory;

public interface UserstoryDao {
	public void create(Userstory userstory);
	public void update(Userstory userstory);
	public Userstory edit(int userstoryId);
	public void delete(int userstoryId);
	public Userstory find(int userstoryId);
	public List<Userstory> getAll();
}
