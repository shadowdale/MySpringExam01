package com.gura.myexam.cafe.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.gura.myexam.cafe.dao.CafeDao;
import com.gura.myexam.cafe.dto.CafeDto;

@Component
public class CafeServiceImpl implements CafeService {
	// 한 페이지에 나타낼 로우의 갯수
	private static final int PAGE_ROW_COUNT = 5;
	
	// 하단 디스플레이 페이지 갯수
	private static final int PAGE_DISPLAY_COUNT = 5;

	@Autowired
	private CafeDao cafeDao;
	
	@Override
	public ModelAndView getList(int pageNum, String keyword, String condition) {
		
		// 검색과 관련된 파라미터를 읽어와 본다.
		
		// boardDto 객체를 생성해서
		CafeDto dto = new CafeDto();
		ModelAndView mView = new ModelAndView();
		
		if(condition.equals("titlecontent")) { // 제목+내용 검색
			dto.setTitle(keyword);
			dto.setContent(keyword);
		} else if(condition.equals("title")) { // 제목 검색
			dto.setTitle(keyword);
		} else if(condition.equals("writer")) { // 작성자 검색
			dto.setWriter(keyword);
		}
		mView.addObject("condition", condition);
		mView.addObject("keyword", keyword);
		
		//보여줄 페이지 데이터의 시작 ResultSet row 번호
		int startRowNum = 1 + (pageNum - 1) * PAGE_ROW_COUNT;
		
		//보여줄 페이지 데이터의 끝 ResultSet row 번호
		int endRowNum = pageNum * PAGE_ROW_COUNT;
		
		//전체 row 의 갯수를 DB 에서 얻어온다.
		int totalRow = cafeDao.getCount(dto);
		
		//전체 페이지의 갯수 구하기
		int totalPageCount = (int)Math.ceil(totalRow / (double)PAGE_ROW_COUNT);
		
		//시작 페이지 번호
		int startPageNum = 1 + ((pageNum - 1) / PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		
		//끝 페이지 번호
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;
		
		//끝 페이지 번호가 잘못된 값이라면 
		if(totalPageCount < endPageNum){
			endPageNum = totalPageCount; //보정해준다. 
		}
		
		// 시작 row 번호와 끝 row 번호를 dto에 담는다.
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		
		
		List<CafeDto> list = cafeDao.getList(dto);
		// 2. request에 담는다
		mView.addObject("list", list);
		
		// 현재 페이지 번호
		mView.addObject("pageNum", pageNum);
		mView.addObject("startPageNum", startPageNum);
		mView.addObject("endPageNum", endPageNum);
		
		// 전체 페이지 갯수
		mView.addObject("totalPageCount", totalPageCount);
		
		return mView;
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
		// TODO Auto-generated method stub
		return 0;
	}

}
