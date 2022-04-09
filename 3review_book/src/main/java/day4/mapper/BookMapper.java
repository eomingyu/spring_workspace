package day4.mapper;

import java.util.List;

import day4.dto.BookDto;

public interface BookMapper {
	void insert(BookDto dto);
	List<BookDto> selectAll();
	BookDto selectOne(String bcode);
}
