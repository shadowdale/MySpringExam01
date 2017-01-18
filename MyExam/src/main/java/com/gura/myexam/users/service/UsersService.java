package com.gura.myexam.users.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.gura.myexam.users.dto.UsersDto;

public interface UsersService {
	// 회원정보를 저장하는 메소드 
	public void insert(UsersDto dto);
	
	// 로그인 폼에 입력한 아이디와 비밀번호가 유효한 정보인지 여부를 리턴해주는 메소드
	public ModelAndView isValid(HttpServletRequest request, UsersDto dto, String uri);
	
	// 인자로 전달된 아이디에 해당하는 회원정보를 리턴해주는 메소드
	public ModelAndView getData(HttpServletRequest request);
	
	// 회원정보를 수정 반영하는 메소드
	public ModelAndView update(HttpServletRequest request, UsersDto dto);
	
	// 인자로 전달하는 id 회원을 삭제하는 메소드
	public ModelAndView delete(HttpServletRequest request);
	
	// 모든 회원의 정보를 리턴해주는 메소드
	public ModelAndView getList();
	
	// 인자로 전달되는 아이디로 가입할수 있는지 여부를 리턴해주는 메소드
	public Map<String, Object> canUseId(String id);
	
}
