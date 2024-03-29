package com.jhl.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jhl.dto.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String NameSpace = "com.jhl.mappers.memberMapper";

	@Override
	public List<MemberVO> selelctMember() throws Exception {
		return sqlSession.selectList(NameSpace+".selectMember");
	}
	
	@Override
	public int isIdExist(String id) throws Exception {
		int bool;
		bool = sqlSession.selectOne(NameSpace+".isIdExist", id);
		return bool;
	}
	
	@Override
	public List<MemberVO> selectOne(String id) throws Exception{
		return sqlSession.selectList(NameSpace+ ".selectOne", id);
		
	}
	
	@Override
	public List<MemberVO> selectOneByMemberNumber(int memberNumber) throws Exception{
		return sqlSession.selectList(NameSpace+ ".selectOneByMemberNumber", memberNumber);
	}
	
}
