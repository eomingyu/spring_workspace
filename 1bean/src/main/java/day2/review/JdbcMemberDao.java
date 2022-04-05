package day2.review;

public class JdbcMemberDao implements MemberDao{

	public JdbcMemberDao() {
		System.out.println("JdbcMemberDao create /////");
	}
	
	
	@Override
	public void find(int idx) {
		System.out.println("JDBC connect : " + idx);
	}

}
