package com.finalyrSE.dao;

import java.util.List;

import com.finalyrSE.model.Fulluserstory;

public interface UserstoryDao {
	public void create(Fulluserstory fulluserstory);
	public void update(Fulluserstory fulluserstory);
	public Fulluserstory edit(int userstoryId);
	public void delete(int userstoryId);
	public Fulluserstory find(int userstoryId);
	public List<Fulluserstory> getAll();
}
