package com.study.service;

import java.util.List;

import com.study.domain.Criteria;
import com.study.domain.ReplyVO;

public interface ReplyService {
	public void addReply(ReplyVO vo) throws Exception;
	public List<ReplyVO> listReply(int bno) throws Exception;
	public void modifyReply(ReplyVO vo) throws Exception;
	public void removeReply(int rno) throws Exception;
	public List<ReplyVO> listReplyPage(int bno, Criteria cri) throws Exception;
	public int count(int bno) throws Exception;
}