package com.jhl.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jhl.dao.PostDAO;
import com.jhl.dto.PostVO;

@Service
public class PostServiceImpl implements PostService  {
	
	@Inject
	private PostDAO dao;

	@Override
	public List<PostVO> selectAll() throws Exception {
		
		return dao.selectAll();
	}
	
	@Override
	public void insertPost(PostVO postVO) throws Exception{
		dao.insertPost(postVO);
	}
	
	@Override
	public void insertPostNoPassword(PostVO postVO) throws Exception{
		dao.insertPostNoPassword(postVO);
	}
	
	@Override
	public void updateviews(int postNumber) throws Exception{
		dao.updateviews(postNumber);
	}
	
	@Override
	public List<PostVO> selectOneByPostNumber(int postNumber) throws Exception{
		return dao.selectOneByPostNumber(postNumber);
	}
	
	@Override
	public void updatePostPassword(PostVO postVO) throws Exception{
		dao.updatePostPassword(postVO);
	}

}
