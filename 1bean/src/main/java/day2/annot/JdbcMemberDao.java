package day2.annot;

import org.springframework.stereotype.Component;

import day2.review.MemberDao;

@Component
public class JdbcMemberDao implements MemberDao{

	public JdbcMemberDao() {
		System.out.println("JdbcMemberDao create /////");
	}
	
	
	@Override
	public void find(int idx) {
		System.out.println("JDBC connect : " + idx);
	}

}
