package com.jhl.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jhl.dto.PostVO;
import com.jhl.service.PostService;



@Controller
public class LogingController {
	
	@Inject
	private PostService postService; 
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView home( 
			@CookieValue(value="isChekedLoginMaintain", required=false) 
			Cookie isChekedLoginMaintain,
			HttpServletRequest request) throws Exception {
		
		String value = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if("isChekedLoginMaintain".equals(cookie.getName())) {
					value = cookie.getValue();
					break;
				}
			}
		}
		
		if(value != null) {
			
			List<PostVO> post = postService.selectAll();
			ModelAndView mav = new ModelAndView();
			mav.addObject("post", post);
			mav.setViewName("redirect:/board");
			return mav;
		}else {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("login");
			return mav;
		}
		
		
		
	}
}
