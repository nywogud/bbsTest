package com.jhl.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jhl.dto.MemberVO;
import com.jhl.service.MemberService;

@Controller
public class WritePostController {

	@Inject
	MemberService memberService;

	@RequestMapping(value = "/writePost", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView write(HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession();
		Integer loggedinMemberNumber = (Integer) session.getAttribute("loggedInMemberNumber");

		List<MemberVO> member = memberService.selectOneByMemberNumber(loggedinMemberNumber);
		ModelAndView mav = new ModelAndView();
		mav.addObject("member", member.get(0));
		mav.setViewName("writePost");

		

		return mav;
	}

	

}
