package com.jhl.service;

import java.util.List;

import com.jhl.dto.PostVO;

public interface PostService {
	
	public List<PostVO> selectAll() throws Exception;


	public void insertPost(PostVO postVO) throws Exception;


	public void insertPostNoPassword(PostVO postVO) throws Exception;


	public void updateviews(int postNumber) throws Exception;


	public List<PostVO> selectOneByPostNumber(int postNumber) throws Exception;

	public void updatePostPassword(PostVO postVO) throws Exception;

}
