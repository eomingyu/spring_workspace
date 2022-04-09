package day4.spring;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import day4.dto.BookRentDto;
import day4.service.BookRentService;

public class BookRentApp {

	public static void main(String[] args) {

		ApplicationContext context = 
				new ClassPathXmlApplicationContext
				("classpath:META-INF/spring/applicationContext.xml");
		SqlSessionTemplate sqlSession =
				(SqlSessionTemplate) context.getBean("sqlSessionTemplate");

		System.out.println(sqlSession);
		
		//BookService 빈 가져오기 : 빈 이름(id)은 스프링 컨테이너가 자동으로 bookService로 합니다.
		
		/*
		 * BookService service = (BookService) context.getBean("bookService");
		 * 
		 * BookDto dto = new BookDto("T1234","불편한 편의점","작가미상","희출판사",null);
		 * service.insert(dto);
		 */
		 BookRentService service = 
				 (BookRentService) context.getBean("bookRentService");
		
		 //BookRentDto dto = new BookRentDto(0,10005,"T1234",null,null,null,0);
		//Builder 패턴으로 객체 생성 후 특정 프로퍼티만 초기화
		 BookRentDto dto = BookRentDto.builder()
				 			.bcode("T1234")
				 			.mem_idx(10005).build();
		 service.insert(dto);
		 
	}

}
