package com.study.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.domain.BoardVO;
import com.study.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {
	
	@Inject
	private BoardDAO dao;
	
	@Test
	public void testCreate()throws Exception{
		BoardVO board = new BoardVO();
		board.setTitle("새로운 글 제목 넣음");
		board.setContent("새로운 글 내용 넣음");
		board.setWriter("유저1");
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
		board.setTitle("수정된 글 제목");
		board.setContent("수정된 글 내용");
		dao.update(board);
	}
	
	@Test
	public void testDelete()throws Exception{
		dao.delete(1);
	}
}