package day2.review;

public class MyMemberServiceImpl implements MemberService{
	private MemberDao dao;
	//사용할 수 있는(의존관계 주입) 클래스를 MemberDao의 구현체로 합니다.
	//해당 클래스는 Mybatis~Dao, Jdbc~Dao 클래스 2개입니다.
	
	public MyMemberServiceImpl() {
		System.out.println("MyMemberServiceImpl create /////");
	}
	public MyMemberServiceImpl(MemberDao dao) {
		System.out.println("MyMemberServiceImpl create //////");
		this.dao=dao;
	}
//	public void setDao(MemberDao dao) {	//의존관계 주입 setter
//		this.dao = dao;
//	}
	
	@Override
	public void find(int idx) {
		//예) 검색 비지니스 로직 처리 : My 방식으로
		System.out.println("My Logic~~~");
		dao.find(idx);
	}

}
