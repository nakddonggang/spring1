package com.study.service;

import java.util.List;

import com.study.domain.BoardVO;
import com.study.domain.Criteria;
import com.study.domain.SearchCriteria;

public interface BoardService {
	public void regist(BoardVO board)throws Exception;
	public BoardVO read(int bno)throws Exception;
	public void modify(BoardVO board)throws Exception;
	public void remove(int bno)throws Exception;
	public List<BoardVO> listAll()throws Exception;
	public List<BoardVO> listCriteria(Criteria cri)throws Exception;
	public int listCountCriteria(Criteria cri)throws Exception;
	public List<BoardVO> listSearchCriteria(SearchCriteria cri)throws Exception;
	public int listSearchCount(SearchCriteria cri)throws Exception;
}