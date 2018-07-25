package com.study.persistence;

public interface PointDAO {	// 사용자의 포인트 처리
	public void updatePoint(String userid, int point) throws Exception;
}