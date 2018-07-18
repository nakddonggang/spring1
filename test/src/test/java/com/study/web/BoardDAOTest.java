package com.study.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.domain.BoardVO;
import com.study.domain.SearchCriteria;
import com.study.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Inject
	private BoardDAO dao;
	
	@Test
	public void testCreate()throws Exception{
		BoardVO board = new BoardVO();
		board.setTitle("���ο� �� ���� ����");
		board.setContent("���ο� �� ���� ����");
		board.setWriter("����1");
		dao.create(board);
	}
	
	@Test
	public void testRead()throws Exception{
		System.out.println(dao.read(1).toString());
	}
	
	@Test
	public void testUpdate()throws Exception{
		BoardVO board = new BoardVO();
		board.setBno(1);
		board.setTitle("������ �� ����");
		board.setContent("������ �� ����");
		dao.update(board);
	}
	
	@Test
	public void testDelete()throws Exception{
		dao.delete(1);
	}
	
	@Test
	public void testDynamic1()throws Exception{
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(1);
		cri.setKeyword("글");
		cri.setSearchType("t");
		
		logger.info("=======================================");
		
		List<BoardVO> list = dao.listSearch(cri);
		
		for(BoardVO boardVO : list) {
			logger.info(boardVO.getBno()+": "+boardVO.getTitle());
		}
		
		logger.info("=======================================");
		logger.info("COUNT: "+dao.listSearchCount(cri));
	}
}