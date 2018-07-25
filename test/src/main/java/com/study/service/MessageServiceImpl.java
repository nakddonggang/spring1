package com.study.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.study.domain.MessageVO;
import com.study.persistence.MessageDAO;
import com.study.persistence.PointDAO;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Inject
	private MessageDAO messageDAO;
	
	@Inject PointDAO pointDAO;

	@Override
	public void addMessage(MessageVO vo) throws Exception {
		messageDAO.create(vo);
		pointDAO.updatePoint(vo.getSender(), 10);
	}

	@Override
	public MessageVO readMessage(String userid, int mno) throws Exception {
		messageDAO.updateState(mno);
		pointDAO.updatePoint(userid, 5);
		return messageDAO.readMessage(mno);
	}
}