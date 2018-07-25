package com.study.persistence;

import com.study.domain.MessageVO;

public interface MessageDAO {	// 메시지 등록, 수정, 업데이트
	public void create(MessageVO vo) throws Exception;
	public MessageVO readMessage(int mno) throws Exception;
	public void updateState(int mno) throws Exception;
}