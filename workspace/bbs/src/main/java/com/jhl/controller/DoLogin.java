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
import com.jhl.service.MemberService;
import com.mysql.cj.api.mysqla.result.Resultset.Type;

@Controller
public class DoLogin {

	@Inject
	private MemberService service;

	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, Model model) throws Exception {


		HttpSession session = request.getSession();
		Integer loggedInMemberNumber = (Integer) session.getAttribute("loggedInMemberNumber");

		List<MemberVO> member = service.selectOneByMemberNumber(loggedInMemberNumber);

		ModelAndView mav = new ModelAndView();
		mav.addObject("loggedinId", member.get(0).getId());
		mav.setViewName("board");

		return mav;
	}

}
