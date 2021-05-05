package com.jhl.dao;

import java.util.List;

import com.jhl.dto.PostVO;

public interface PostDAO {
	
	public List<PostVO> selectAll() throws Exception;

	public void insertPost(PostVO postVO) throws Exception;

	public void insertPostNoPassword(PostVO postVO) throws Exception;

}
