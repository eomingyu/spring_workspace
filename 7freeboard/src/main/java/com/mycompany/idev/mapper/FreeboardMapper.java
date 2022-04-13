package com.mycompany.idev.mapper;

import java.util.List;
import java.util.Map;

import com.mycompany.idev.dto.Freeboard;

public interface FreeboardMapper {
	List<Freeboard> getPageList(Map<String,Integer> map);
	int getCount();
}
