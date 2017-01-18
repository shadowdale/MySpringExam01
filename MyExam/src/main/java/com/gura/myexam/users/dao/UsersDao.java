package com.gura.myexam.users.dao;

import java.util.List;

import com.gura.myexam.users.dto.UsersDto;

public interface UsersDao {
	//회원정보를 저장하는 메소드 
	public void insert(UsersDto dto);//insert()
	
	//로그인 폼에 입력한 아이디와 비밀번호가 유효한 정보인지 여부를 
	//리턴해주는 메소드
	public UsersDto isValid(UsersDto dto); // isValid()
	
	// 인자로 전달된 아이디에 해당하는 회원정보를 리턴해주는 메소드
	public UsersDto getData(String id);
	
	//회원정보를 수정 반영하는 메소드
	public void update(UsersDto dto);
	
	//인자로 전달하는 id 회원을 삭제하는 메소드
	public void delete(String id);
	
	//모든 회원의 정보를 리턴해주는 메소드
	public List<UsersDto> getList(); // getList()
	
	// 인자로 전달되는 아이디로 가입할수 있는지 여부를 리턴해주는 메소드
	public String canUseId(String id);
	
}
