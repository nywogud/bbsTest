package com.jhl.dao;

import java.util.List;

import com.jhl.dto.PostVO;

public interface PostDAO {
	
	public List<PostVO> selectAll() throws Exception;

}
