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
}