package com.finalyrSE.dao;

import java.util.List;

import com.finalyrSE.model.Epic;

public interface EpicDao {
	public Epic find(int epicId);
	public List<Epic> getAll();
}
