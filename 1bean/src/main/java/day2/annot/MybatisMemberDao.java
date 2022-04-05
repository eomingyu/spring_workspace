package day2.annot;

import org.springframework.stereotype.Component;

import day2.review.MemberDao;

@Component
public class MybatisMemberDao implements MemberDao{

	public MybatisMemberDao() {
		System.out.println("MybatisMemberDao create /////");
	}
	
	
	@Override
	public void find(int idx) {
		System.out.println("Mybatis mapping : " + idx);
	}

}
