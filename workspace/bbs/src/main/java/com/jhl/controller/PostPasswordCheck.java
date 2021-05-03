package com.jhl.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostPasswordCheck {

	@RequestMapping(value = "/postPasswordCheck", method = RequestMethod.POST)
	public ModelAndView write(HttpServletRequest request) throws Exception {

		ModelAndView mav = new ModelAndView();

		if (request.getParameter("postPassword") != null && request.getParameter("postPasswordCheck") != null) {

			String postPassword = request.getParameter("postPassword");
			String postPasswordCheck = request.getParameter("postPasswordCheck");
			
			mav.setViewName("../../postPasswordSet");

			if (!(postPassword.trim().equals(postPasswordCheck.trim()))) {
				String isMatching = "no";
				mav.addObject("isMatching", isMatching);
				
				return mav;
			} else if(postPassword.trim().equals(postPasswordCheck.trim())) {
				String isMatching = "yes";
				mav.addObject("isMatching", isMatching);
				mav.addObject("postPassword", postPassword);
				return mav;
			}
		}

		return mav;
	}
}
