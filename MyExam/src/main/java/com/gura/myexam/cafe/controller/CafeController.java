package com.gura.myexam.cafe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.myexam.cafe.service.CafeService;

@Controller
public class CafeController {
	
	@Autowired
	private CafeService cafeService;
	
	// 글목록 보기 요청 처리
	@RequestMapping("/cafe/list")
	public ModelAndView listRequert(HttpServletRequest request, @RequestParam(defaultValue="1") int pageNum
		, @RequestParam(defaultValue="") String keyword, @RequestParam(defaultValue="") String condition) {
		
		ModelAndView mView = cafeService.getList(pageNum, keyword, condition);
		mView.setViewName("/cafe/list");
		return mView;
	}

}
