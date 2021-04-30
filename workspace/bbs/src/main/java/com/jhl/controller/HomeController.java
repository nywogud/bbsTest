package com.jhl.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( 
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
			return "redirect:/board";
		}else {
			return "login";
		}
		
		
		
	}
}
