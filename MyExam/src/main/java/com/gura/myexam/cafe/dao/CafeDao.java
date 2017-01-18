package com.gura.myexam.cafe.dao;

import java.util.List;

import com.gura.myexam.cafe.dto.CafeDto;

public interface CafeDao {

	// 글 목록을 리턴해주는 메소드
	public List<CafeDto> getList(CafeDto dto);
	
	// 글 정보 저장하는 메소드
	public void insert(CafeDto dto);
	
	// 글 정보를 리턴해주는 메소드
	public CafeDto getData(CafeDto dto);
	
	// 조회수를 1증가 시키는 메소드
	public void increaseViewCount(int num);
	
	//
	public void update(CafeDto dto);
	
	public void delete(int num);
	
	// 전체 글의 갯수를 리턴해주는 메소드
	public int getCount(CafeDto dto);
}
