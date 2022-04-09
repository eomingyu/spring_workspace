package day4.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder	//생성자 대신 프로퍼티 값을 설정 : 빌더 패턴
public class BookRentDto {
	private int rent_no;		//sequence 자동생성
	private int mem_idx;
	private String bcode;
	private Date rent_date;		//대여날짜 : sysdate
	private Date exp_date;		//반납기한날짜=대여날짜+14일, insert 후에 update로 변경
	private Date return_date;	//실제 반납일
	private int delay_days;		//기본값 0
}
//내부 클래스 : 클래스 안의 클래스 BookRentDtoBuilder