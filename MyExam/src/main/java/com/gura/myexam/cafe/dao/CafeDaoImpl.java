package com.gura.myexam.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gura.myexam.cafe.dto.CafeDto;

@Controller
public class CafeDaoImpl implements CafeDao{

	@Autowired
	private SqlSession session;
	
	@Override
	public List<CafeDto> getList(CafeDto dto) {
		List<CafeDto> list = session.selectList("cafe.getList", dto);
		return list;
	}

	@Override
	public void insert(CafeDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CafeDto getData(CafeDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void increaseViewCount(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CafeDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCount(CafeDto dto) {
		int num = session.selectOne("cafe.getCount", dto);
		return num;
	}

}
