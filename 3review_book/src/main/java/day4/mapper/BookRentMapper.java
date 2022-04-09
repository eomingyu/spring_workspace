package day4.mapper;

import java.util.List;

import day4.dto.BookRentDto;

public interface BookRentMapper {
	int insert(BookRentDto dto);
	void updateExpDate(int rent_no);	//트랜잭션 연습용 : 실제로는 프론트엔드에서 처리
	
	List<BookRentDto> selectAll();
}
