package com.koreait.idev.mapper;

import java.util.List;

import com.koreait.idev.model.Gallery;

public interface GalleryMapper {
	List<Gallery> selectAll();
	int insert(Gallery gallery);
}
