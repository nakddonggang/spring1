package com.study.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class PointDAOImpl implements PointDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.study.mapper.PointMapper";

	@Override
	public void updatePoint(String userid, int point) throws Exception {
		Map map = new HashMap<>();
		map.put("userid", userid);
		map.put("point", point);
		session.update(namespace+".updatePoint", map);
	}
}