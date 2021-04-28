package com.jhl.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jhl.dto.MemberVO;
import com.jhl.service.MemberService;

@Controller
public class UserCheckController {

	@Inject
	private MemberService service;

	@RequestMapping(value = "/userCheck", method = RequestMethod.POST)
	public String home(HttpServletRequest request, Model model) throws Exception {

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String loggedinMaintain = request.getParameter("loggedinMaintain");

		System.out.println(id);
		System.out.println(password);
		System.out.println(loggedinMaintain);

		int isIdExsist = service.isIdExist(id.trim());

		if (isIdExsist == 1) {

			List<MemberVO> member = service.selectOne(id.trim());
			if (password.trim().equals(member.get(0).getPassword().trim().toString())) {
				System.out.println("아이디 비번 일치");
				// 로그인, 로그인 유지 기능 구현해야 함
				return "temp"; //게시판으로 보내야 함.
			} else {
				model.addAttribute("msgCoincidePassword", "비밀번호가 일치하지 않습니다.");
				return "login";

			}
		} 
		
		else {
			model.addAttribute("msgNotExistId", "아이디가 존재하지 않습니다.");
			return "login";
		}

	}

}
