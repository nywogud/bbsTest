package com.jhl.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostPasswordController {
		
		private String postPassword;

		@ResponseBody
		@RequestMapping(value = "/postPassword",  method=RequestMethod.POST)
		public void postPassword(@RequestParam Map<String, String> postPassword){
			
			this.postPassword = postPassword.get("postPassword");
			
		}

		public String getPostPassword() {
			return postPassword;
		}

	}

