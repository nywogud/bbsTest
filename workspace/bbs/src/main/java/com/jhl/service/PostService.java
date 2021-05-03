package com.jhl.service;

import java.util.List;

import com.jhl.dto.PostVO;

public interface PostService {
	
	public List<PostVO> selectAll() throws Exception; 

}
