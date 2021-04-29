package com.jhl.service;

import java.util.List;

import com.jhl.dto.MemberVO;

public interface MemberService {
	
	public List<MemberVO> selectMember() throws Exception;
	
	public int isIdExist(String id) throws Exception;
	
	public List<MemberVO> selectOne(String id) throws Exception;
	
	public List<MemberVO> selectOneByMemberNumber(int memberNumber) throws Exception;

}
