package com.jhl.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jhl.dto.MemberVO;
import com.jhl.service.MemberService;

@Controller
public class UserCheckController {

	@Inject
	private MemberService service;

	@RequestMapping(value = "/userCheck", method = RequestMethod.POST)
	public String userCheck(HttpServletRequest request, Model model, RedirectAttributes attributes) throws Exception {

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String loggedinMaintain = request.getParameter("loggedinMaintain");

//		System.out.println(id);
//		System.out.println(password);
//		System.out.println(loggedinMaintain);

		int isIdExsist = service.isIdExist(id.trim());

		if (isIdExsist == 1) {
			//아이디가 존재하는 경우
			List<MemberVO> member = service.selectOne(id.trim());
			if (password.trim().equals(member.get(0).getPassword().trim().toString())) {
				
				//회원번호로 세션 설정
				HttpSession session = request.getSession();
				session.setAttribute("loggedInMemberNumber", member.get(0).getMemberNumber());
				
				attributes.addFlashAttribute("memberNumberInLog", member.get(0).getMemberNumber());
				attributes.addFlashAttribute("loggedinMaintain", loggedinMaintain);
				
				return "redirect:/board";

			}
			else {
				model.addAttribute("msgCoincidePassword", "비밀번호가 일치하지 않습니다.");
				return "login";
			}

		} else {
			model.addAttribute("msgNotExistId", "아이디가 존재하지 않습니다.");
			return "login";
		}
	}
}
