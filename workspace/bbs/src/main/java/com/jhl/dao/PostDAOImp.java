package com.jhl.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jhl.dto.PostVO;

@Repository
public class PostDAOImp implements PostDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String NameSpace = "com.jhl.mappers.postMapper";

	@Override
	public List<PostVO> selectAll() throws Exception {
		return sqlSession.selectList(NameSpace + ".selectAll");
	}
	
	@Override
	public void insertPost(PostVO postVO) throws Exception{
		sqlSession.insert(NameSpace + ".insertPost", postVO);
	}
	
	@Override
	public void insertPostNoPassword(PostVO postVO) throws Exception{
		sqlSession.insert(NameSpace + ".insertPostNoPassword", postVO);
	}
	
	@Override
	public void updateviews(int postNumber) throws Exception{
		sqlSession.insert(NameSpace + ".updateviews" , postNumber);
	}
	
	@Override
	public List<PostVO> selectOneByPostNumber(int postNumber) throws Exception{
		return sqlSession.selectList(NameSpace+".selectOneByPostNumber", postNumber);
	}
	
	@Override
	public void updatePostPassword(PostVO postVO) throws Exception{
		sqlSession.update(NameSpace+".updatePostPassword", postVO);
	}

}
