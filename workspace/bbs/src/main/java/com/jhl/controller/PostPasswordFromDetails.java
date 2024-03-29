package com.jhl.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhl.dto.PostVO;
import com.jhl.service.PostService;

@Controller
public class PostPasswordFromDetails {
	
	@Inject
	PostService postService; 
	
	@ResponseBody
	@RequestMapping(value="/postPasswordFromDetails", method=RequestMethod.POST)
	public void postPasswordFromDetails(HttpServletRequest request) throws Exception {
		
		
		int postNumber = Integer.parseInt(request.getParameter("postNumber"));
		String postPassword = request.getParameter("postPassword");
		
		PostVO postVO = new PostVO();
		postVO.setPostPassword(postPassword);
		postVO.setPostNumber(postNumber);
		
		postService.updatePostPassword(postVO);
		
		System.out.println("PostPasswordFromDetailsCo : DB 업데이트는 성공");
		
	}
	
	@RequestMapping(value="/temp", method=RequestMethod.GET)
	public String temp() throws Exception {
		return "temp";
	}
	
}
