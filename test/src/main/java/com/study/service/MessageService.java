package com.study.service;

import com.study.domain.MessageVO;

public interface MessageService {
	public void addMessage(MessageVO vo) throws Exception;
	public MessageVO readMessage(String userid, int mno) throws Exception;
}