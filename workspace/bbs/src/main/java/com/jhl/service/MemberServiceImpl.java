package com.jhl.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jhl.dao.MemberDAO;
import com.jhl.dto.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAO dao;
	

	@Override
	public List<MemberVO> selectMember() throws Exception {
		return dao.selelctMember();
	}
	
	@Override
	public int isIdExist(String id) throws Exception {
		System.out.println("service : " + dao.isIdExist(id));
		return dao.isIdExist(id);
	}
	
	@Override
	public List<MemberVO> selectOne(String id) throws Exception {
		return dao.selectOne(id);
	}
	
	@Override
	public List<MemberVO> selectOneByMemberNumber(int memberNumber) throws Exception{
		return dao.selectOneByMemberNumber(memberNumber);
	}
	
}
