package com.jhl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostPasswordController {
		
		static String setPostPassword;

		@ResponseBody
		@RequestMapping(value = "/postPassword",  method=RequestMethod.POST)
		public void postPassword(String postPassword){
			
			PostPasswordController.setPostPassword = postPassword;
			
		}

	}

