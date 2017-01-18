package com.gura.myexam.users.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.gura.myexam.users.dao.UsersDao;
import com.gura.myexam.users.dto.UsersDto;

@Component
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDao usersDao;
	
	@Override
	public void insert(UsersDto dto) {
		usersDao.insert(dto);
	}

	@Override
	public ModelAndView isValid(HttpServletRequest request, UsersDto dto, String uri) {
		UsersDto resultDto = usersDao.isValid(dto);
		ModelAndView mView = new ModelAndView();
		if(resultDto != null) {
			request.getSession().setAttribute("id", resultDto.getId());
			mView.addObject("msg", resultDto.getId()+"님 로그인 되었습니다.");
			mView.addObject("redirectUri", uri);
		} else {
			mView.addObject("msg", "아이디 혹은 비밀번호가 틀려요!");
			String location = request.getContextPath()+"/users/signinform.do?uri="+uri;
			mView.addObject("redirectUri", location);
		}
		return mView;
	}

	@Override
	public ModelAndView getData(HttpServletRequest request) {
		String id = (String)request.getSession().getAttribute("id");
		UsersDto dto = usersDao.getData(id);
		ModelAndView mView = new ModelAndView();
		mView.addObject("dto", dto);
		return mView;
	}

	@Override
	public ModelAndView update(HttpServletRequest request, UsersDto dto) {
		usersDao.update(dto);
		ModelAndView mView = new ModelAndView();
		mView.addObject("msg", dto.getId()+"님의 회원 정보를 수정했습니다");
		mView.addObject("redirectUri", request.getContextPath());
		return mView;
	}

	@Override
	public ModelAndView delete(HttpServletRequest request) {
		String id = (String)request.getSession().getAttribute("id");
		usersDao.delete(id);
		request.getSession().invalidate();
		ModelAndView mView = new ModelAndView();
		request.setAttribute("msg", "회원 탈퇴 처리 되었습니다");
		request.setAttribute("redirectUri", request.getContextPath());
		return mView;
	}

	@Override
	public ModelAndView getList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Map<String, Object> canUseId(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		String result = usersDao.canUseId(id);
		if(result == null) {
			map.put("canUse", true);
		} else {
			map.put("canUse", false);
		}
		return map;
	}

}
