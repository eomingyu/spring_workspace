package day3.mapper;

import java.util.List;

import day3.dto.Member;

public interface MemberTblMapper {
	//member.xml 매퍼 파일과 연관되는 인터페이스입니다.
	//추상 메소드는 매퍼파일의 id로 작성합니다.
	void insert(Member member);
	List<Member> selectAll();
}
