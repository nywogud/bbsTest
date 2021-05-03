package com.jhl.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jhl.dto.MemberVO;
import com.jhl.dto.PostVO;
import com.jhl.service.MemberService;
import com.jhl.service.PostService;

@Controller
public class UserCheckController {

	@Inject
	private MemberService memberservice;

	@Inject
	private PostService postService;

	@RequestMapping(value = "/userCheck", method = RequestMethod.POST)
	public String userCheck(HttpServletRequest request, Model model, RedirectAttributes attributes,
			HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String loggedInMaintain = request.getParameter("loggedinMaintain");

		int isIdExsist = memberservice.isIdExist(id.trim());

		if (isIdExsist == 1) {
			// 아이디가 존재하는 경우
			List<MemberVO> member = memberservice.selectOne(id.trim());
			if (password.trim().equals(member.get(0).getPassword().trim().toString())) {

				// 회원번호로 세션 설정
				HttpSession session = request.getSession();
				session.setAttribute("loggedInMemberNumber", member.get(0).getMemberNumber());

				if (loggedInMaintain != null) {

					Cookie cookie = new Cookie("isChekedLoginMaintain", loggedInMaintain.toString());
					cookie.setMaxAge(60 * 60 * 24 * 30);
					cookie.setPath("/");
					response.addCookie(cookie);

					List<PostVO> post = postService.selectAll();

					model.addAttribute("post", post);
					return "redirect:/board";

				} else {
					List<PostVO> post = postService.selectAll();

					model.addAttribute("post", post);
					return "redirect:/board";
				}

			} else {
				model.addAttribute("msgCoincidePassword", "비밀번호가 일치하지 않습니다.");
				return "login";
			}

		} else {
			model.addAttribute("msgNotExistId", "아이디가 존재하지 않습니다.");
			return "login";
		}
	}
}
