package com.study.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.domain.MemberVO;
import com.study.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDAOTest {
	
	@Inject
	private MemberDAO dao;
	
	@Test
	public void testTime() throws Exception{
		System.out.println(dao.getTime());
	}
	
	@Test
	public void testInsertMember() throws Exception{
		MemberVO vo = new MemberVO();
		vo.setUserid("user00");
		vo.setUserpw("1234");
		vo.setUsername("UserName");
		vo.setEmail("user00@aaa.com");
		dao.insertMember(vo);
	}
}