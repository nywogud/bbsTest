package com.jhl.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jhl.dto.MemberVO;
import com.jhl.dto.PostVO;
import com.jhl.service.MemberService;
import com.jhl.service.PostService;

@Controller
public class InsertPostController {

	@Inject
	MemberService memberService;

	@Inject
	PostService postService;

	@RequestMapping(value = "/insertPost", method = RequestMethod.POST)
	public ModelAndView insetPost(HttpServletRequest request) throws Exception {
		System.out.println("insertPost가 보내는 값 : " + PostPasswordController.setPostPassword);

		HttpSession session = request.getSession();
		Integer loggedInMemberNumber = (Integer) session.getAttribute("loggedInMemberNumber");

		List<MemberVO> member = memberService.selectOneByMemberNumber(loggedInMemberNumber);

		PostVO postVO = new PostVO();

		// 여기서 insert 시작
		if (PostPasswordController.setPostPassword != null) {
			postVO.setPostTitle(request.getParameter("postTitle"));
			postVO.setContents(request.getParameter("postContents"));
			postVO.setPostWriter(member.get(0).getName());
			postVO.setPostPassword(PostPasswordController.setPostPassword);

			postService.insertPost(postVO);

			List<PostVO> post = postService.selectAll();

			ModelAndView mav = new ModelAndView();
			mav.addObject("member", member.get(0));
			mav.addObject("post", post);
			mav.setViewName("redirect:/board");
			
			PostPasswordController.setPostPassword = null;
			
			return mav;
			
		} else {
			
			postVO.setPostTitle(request.getParameter("postTitle"));
			postVO.setContents(request.getParameter("postContents"));
			postVO.setPostWriter(member.get(0).getName());
			
			postService.insertPostNoPassword(postVO);

			List<PostVO> post = postService.selectAll();

			ModelAndView mav = new ModelAndView();
			mav.addObject("member", member.get(0));
			mav.addObject("post", post);
			mav.setViewName("redirect:/board");

			return mav;
		}
		
	}
}
