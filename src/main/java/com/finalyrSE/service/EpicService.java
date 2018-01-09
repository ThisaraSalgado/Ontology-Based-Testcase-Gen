package com.finalyrSE.service;

import java.util.List;
import java.util.Map;

import com.finalyrSE.model.Epic;

public interface EpicService {
	public Epic find(int epicId);
	public List<Epic> getAll();
	public List<Map> getEpicnames();
}
