package com.study.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.domain.BoardVO;
import com.study.domain.Criteria;
import com.study.domain.PageMaker;
import com.study.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(BoardVO board, Model model)throws Exception{
		
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(BoardVO board, RedirectAttributes rttr)throws Exception{
		service.regist(board);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board/listPage";
	}
	
	@RequestMapping(value="/listPage", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri")Criteria cri, Model model)throws Exception{
		model.addAttribute("list", service.listCriteria(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model)throws Exception{
		model.addAttribute(service.read(bno));	// �̸� ���� ������ ������ �ڵ����� Ŭ������ �̸��� �ҹ��ڷ� �����ؼ� ���
												// �� ��쿡�� BoardVO Ŭ������ ��ü�̹Ƿ�, boardVO��� �̸����� �����
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr)throws Exception{
		service.remove(bno);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board/listPage";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyGET(int bno, Model model)throws Exception{
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPOST(BoardVO board, RedirectAttributes rttr)throws Exception{
		service.modify(board);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board/listPage";
	}
	
	
}