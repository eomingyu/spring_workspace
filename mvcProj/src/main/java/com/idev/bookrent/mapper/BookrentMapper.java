package com.idev.bookrent.mapper;

import java.util.List;

import com.idev.bookrent.dto.BookDto;
import com.idev.bookrent.dto.BookRentDto;

public interface BookrentMapper {
	List<BookDto> selectBooks();
	int countByBcode(String bcode);
	void insertRent(BookRentDto dto);
	List<BookRentDto> getRentList();
	void updateDelays();
}
