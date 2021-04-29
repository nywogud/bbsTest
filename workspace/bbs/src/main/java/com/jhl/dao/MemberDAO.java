package com.jhl.dao;

import java.util.List;

import com.jhl.dto.MemberVO;

public interface MemberDAO {
	
	public List<MemberVO> selelctMember() throws Exception;
	
	public int isIdExist(String id) throws Exception;
	
	public List<MemberVO> selectOne(String id) throws Exception;

	public List<MemberVO> selectOneByMemberNumber(int memberNumber) throws Exception;


}
