package com.jhl.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.jhl.dto.MemberVO;
import com.jhl.dto.PostVO;
import com.jhl.service.MemberService;
import com.jhl.service.PostService;
import com.mysql.cj.api.mysqla.result.Resultset.Type;

@Controller
public class DoLogin {

	@Inject
	private MemberService memberService;
	
	@Inject
	private PostService postService;

	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, Model model) throws Exception {


		HttpSession session = request.getSession();
		Integer loggedInMemberNumber = (Integer) session.getAttribute("loggedInMemberNumber");

		List<MemberVO> member = memberService.selectOneByMemberNumber(loggedInMemberNumber);
		
		List<PostVO> post = postService.selectAll();

		ModelAndView mav = new ModelAndView();
		mav.addObject("member", member.get(0));
		mav.addObject("post", post);
		mav.setViewName("board");

		return mav;
	}

}
