package dao;

import java.util.ArrayList;
import java.util.List;

import dto.MemberDto;

public class MemberDao {
	
	private List<MemberDto> list = new ArrayList();
	
	public void insert(MemberDto dto){
		list.add(dto);
	}
}
