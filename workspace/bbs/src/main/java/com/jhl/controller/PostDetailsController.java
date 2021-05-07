package com.jhl.controller;


import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jhl.dto.MemberVO;
import com.jhl.dto.PostVO;
import com.jhl.service.MemberService;
import com.jhl.service.PostService;


@Controller
public class PostDetailsController {

	@Inject
	PostService postService;
	
	@Inject
	MemberService memberService;
	
	@RequestMapping(value = "/postDetails", method = RequestMethod.GET)
	public ModelAndView postDetails(HttpServletRequest request) throws Exception {
		
		int postNumber = Integer.parseInt(request.getParameter("postNumber"));		
		postService.updateviews(postNumber);
		
		HttpSession session = request.getSession();
		Integer loggedInMemberNumber = (Integer) session.getAttribute("loggedInMemberNumber");
		
		List<MemberVO> member = memberService.selectOneByMemberNumber(loggedInMemberNumber);
		
		List<PostVO> post =postService.selectOneByPostNumber(postNumber);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("post", post.get(0));
		mav.addObject("member", member.get(0));
		mav.setViewName("postDetails");
			
		return mav;
	}

}