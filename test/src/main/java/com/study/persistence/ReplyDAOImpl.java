package com.study.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.study.domain.Criteria;
import com.study.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.study.mapper.ReplyMapper";

	@Override
	public List<ReplyVO> list(int bno) throws Exception {
		return session.selectList(namespace+".list", bno);
	}

	@Override
	public List<ReplyVO> listPage(int bno, Criteria cri) throws Exception {
		Map map = new HashMap<>();
		map.put("bno", bno);
		map.put("cri", cri);
		return session.selectList(namespace+".listPage", map);
	}

	@Override
	public int count(int bno) throws Exception {
		return session.selectOne(namespace+".count", bno);
	}

	@Override
	public void create(ReplyVO vo) throws Exception {
		session.insert(namespace+".create", vo);
	}

	@Override
	public void update(ReplyVO vo) throws Exception {
		session.update(namespace+".update", vo);
	}

	@Override
	public void delete(int rno) throws Exception {
		session.delete(namespace+".delete", rno);
	}
	
}