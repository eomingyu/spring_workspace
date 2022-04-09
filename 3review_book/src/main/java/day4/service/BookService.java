package day4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import day4.dto.BookDto;
import day4.mapper.BookMapper;

@Component
public class BookService {
	private BookMapper mapper;
	
	//의존관계 주입 : ByType(일치하는 타입을 알아서 찾는다)
	@Autowired
	public BookService(BookMapper mapper) {
		this.mapper = mapper;
	}
	public void insert(BookDto dto) {
		mapper.insert(dto);
	}
}
