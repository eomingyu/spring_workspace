package com.mycompany.idev.mapper;

import java.util.List;

import com.mycompany.idev.dto.Comments;

public interface CommentMapper {
	void insert(Comments dto);
	List<Comments> list(int mref);
	void commentCountUp(int idx);
	void commentCountDown(int idx);
	void delete(int idx);
	void updateCmtCount(int idx);
}
