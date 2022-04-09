package day4.mapper;

import java.util.List;
import java.util.Map;

import day4.dto.MemberDto;
//sql과 직접 매핑되는 동작을 추상메소드로 정의
public interface MemberMapper {
	void insert(MemberDto dto);
	List<MemberDto> selectAll();
	MemberDto selectOne(int mem_idx);
	MemberDto login(Map<String,String> map);
}
