package day2.annot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import day2.review.MemberDao;
import day2.review.MemberService;

@Component("myService")	//value속성 생략. bean id "myService"로 지정
public class MyMemberServiceImpl implements MemberService{
//	@Autowired
//	@Qualifier("jdbcMemberDao")		//기본생성자 있을 때만 가능
	private MemberDao dao;
	//사용할 수 있는(의존관계 주입) 클래스를 MemberDao의 구현체로 합니다.
	//해당 클래스는 Mybatis~Dao, Jdbc~Dao 클래스 2개입니다.
	
	//커스텀 생성자 : 의존관계 주입. 여러 개 구현체가 있을 때는 bean id 지정해야 합니다.
	public MyMemberServiceImpl(@Qualifier("jdbcMemberDao") MemberDao dao) {
		System.out.println("MyMemberServiceImpl create //////");
		this.dao=dao;
	}
	public void setDao(MemberDao dao) {	//의존관계 주입 setter
		this.dao = dao;
	}
	
	@Override
	public void find(int idx) {
		//예) 검색 비지니스 로직 처리 : My 방식으로
		System.out.println("My Logic~~~");
		dao.find(idx);
	}

}
