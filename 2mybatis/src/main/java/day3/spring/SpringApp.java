package day3.spring;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import day3.dto.Member;
import day3.dto.Money;
import day3.mapper.MemberTblMapper;
import day3.mapper.MoneyTblMapper;

public class SpringApp {

	@Autowired
	MemberTblMapper dao;
	
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext
				("classpath:META-INF/spring/applicationContext.xml");
		//데이터베이스 연결이 되는지 확인
		SqlSessionTemplate sqlSession = (SqlSessionTemplate) context.getBean("sqlSessionTemplate");
		System.out.println(sqlSession);	//null 아닌 값으로 출력이 되면 연결 성공
		
		//MemberTblMapper은 인터페이스지만 mybatis-spring은 인터페이스를 이용하여
		//자동으로 데이터베이스 컬럼과 Member 클래스를 연결하는 mapper bean 객체를 생성합니다.
		//bean 이름은 인터페이스 이름과 동일하고 첫글자만 소문자
		MemberTblMapper mapper
		= (MemberTblMapper) context.getBean("memberTblMapper");
		List<Member> list = mapper.selectAll();
		System.out.println(list);
		
		MoneyTblMapper mapper2
		= (MoneyTblMapper) context.getBean("moneyTblMapper");
		List<Money> list2 = mapper2.selectAll();
		System.out.println(list2);
		//main 메소드에서 다른 클래스의 빈 객체를 가져오는 것은 getBean으로 가져와서 테스트를 해야합니다.
		// -> spring-test 기능을 이용해서 테스트용 코드를 작성해봅시다.
	
	}

}
