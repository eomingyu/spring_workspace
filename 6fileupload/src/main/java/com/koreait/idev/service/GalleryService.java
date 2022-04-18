package com.koreait.idev.service;

import java.util.List;

import com.koreait.idev.model.Gallery;

public interface GalleryService {
	List<Gallery> getList();
	int save(Gallery gallery);
}
