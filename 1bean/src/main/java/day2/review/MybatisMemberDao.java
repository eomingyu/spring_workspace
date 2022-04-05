package day2.review;

public class MybatisMemberDao implements MemberDao{

	public MybatisMemberDao() {
		System.out.println("MybatisMemberDao create /////");
	}
	
	
	@Override
	public void find(int idx) {
		System.out.println("Mybatis mapping : " + idx);
	}

}
