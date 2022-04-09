package day4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import day4.dto.MemberDto;
import day4.mapper.MemberMapper;

@Component
public class MemberService {
	
	private MemberMapper mapper;
	//의존 관계 주입
	@Autowired	//생성자에서는 생략 가능
	public MemberService(MemberMapper mapper) {
		this.mapper = mapper;
	}
	
	public void insert(MemberDto dto) {
		mapper.insert(dto);
	}
		
}
