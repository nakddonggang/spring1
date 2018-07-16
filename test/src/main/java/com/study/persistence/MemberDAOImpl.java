package com.study.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.study.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.study.mapper.MemberMapper";

	@Override
	public String getTime() {
		return sqlSession.selectOne(namespace+".getTime");
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert(namespace+".insertMember", vo);
	}

	@Override
	public MemberVO readMember(String userid) throws Exception {
		return sqlSession.selectOne(namespace+".readMember", userid);
	}

	@Override
	public MemberVO readWithPW(String userid, String userpw) throws Exception {
		Map map = new HashMap<>();
		map.put("userid", userid);
		map.put("userpw", userpw);
		return sqlSession.selectOne(namespace+".readWithPW", map);
	}
	
}