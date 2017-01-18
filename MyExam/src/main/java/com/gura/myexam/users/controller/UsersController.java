package com.gura.myexam.users.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gura.myexam.users.dto.UsersDto;
import com.gura.myexam.users.service.UsersService;

@Controller
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	// 회원 가입폼 요청처리
	@RequestMapping("/users/signupform")
	public String signupformRequest() {
		return "/users/signupform";
	}
	
	// 중복아이디 체크 요청 처리
	@RequestMapping("/users/checkid")
	@ResponseBody
	public Map<String, Object> checkidRequest(@RequestParam String inputId) {
		Map<String, Object> map = usersService.canUseId(inputId);
		return map;
	}
	
	// 회원가입 요청 처리
	@RequestMapping("/users/signup")
	public String signupRequest(@ModelAttribute UsersDto dto) {
		usersService.insert(dto);;
		return "redirect:../home.do";
	}
	
	// 로그인 가입폼 요청처리
	@RequestMapping("/users/signinform")
	public String signinformRequest() {
		return "/users/signinform";
	}
	
	// 로그인 요청처리
	@RequestMapping("/users/signin")
	public ModelAndView signinReqest(HttpServletRequest request, @ModelAttribute UsersDto dto, @RequestParam String uri) {
		ModelAndView mView = usersService.isValid(request, dto, uri);
		mView.setViewName("/users/alert");
		return mView;
	}
	
	// 로그아웃 요청 처리
	@RequestMapping("/users/signout")
	public ModelAndView signoutRequesrt(HttpServletRequest request) {
		request.getSession().invalidate();
		
		ModelAndView mView =  new ModelAndView();
		mView.addObject("msg", "로그 아웃 되었습니다.");
		mView.addObject("redirectUri", request.getContextPath());
		mView.setViewName("/users/alert");
		return mView;
	}
	
	// 회원정보 보기 요청 처리
	@RequestMapping("/users/private/info")
	public ModelAndView infoRequest(HttpServletRequest request) {

		// DB에서 정보를 읽어온다.
		ModelAndView mView = usersService.getData(request);
		
		mView.setViewName("/users/private/info");
		return mView;
	}
	
	// 회원 정보 업데이트폼 요청 처리
	@RequestMapping("/users/private/updateform")
	public ModelAndView updateformReqest(HttpServletRequest request) {
		ModelAndView mView = usersService.getData(request);
		mView.setViewName("/users/private/updateform");
		return mView;
	}
	
	// 회원 정보 업데이트 요청 처리
	@RequestMapping("/users/private/update")
	public ModelAndView updateReqest(HttpServletRequest request, @ModelAttribute UsersDto dto) {
		ModelAndView mView = usersService.update(request, dto);
		mView.setViewName("/users/alert");
		return mView;
	}
	
	// 회원 탈퇴 요청처리
	@RequestMapping("/users/private/delete")
	public ModelAndView deleteReqest(HttpServletRequest request) {
		ModelAndView mView = usersService.delete(request);
		mView.setViewName("/users/alert");
		return mView;
	}
}
