package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.MemberDao;
import dto.MemberDto;

@Controller
public class WebController {
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping("/input")
	public String input() {
		return "/input";
	}
	
	@RequestMapping("/action")
	public String action() {
		return "/step/step1";
	}
	
	@RequestMapping("/step1")
	public String step1(boolean step1_check) {
		if(step1_check) {
			return "/step/step2";
		} else {
			return "/step/step1";
		}
	}
	@RequestMapping("/step2")
	public String step2(MemberDto memberDto) {
		memberDao.insert(memberDto);
		return "/step/step3";
	}
	
	
}
