package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.MemberDao;
import dto.MemberDto;


@Controller
public class WebController {
	
	@Autowired
	private MemberDao memberDao;
	
//	@Autowired
//	public void setMemberDao(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}
	
	@RequestMapping("/main")
	public String main() {
		return "/main";
	}
	
	@GetMapping("/input")
	public String input() {
		return "/input";
	}
	
	@PostMapping("/inputAdd")
	public String inputAdd(MemberDto memberDto) {
		memberDao.insert(memberDto);
		return "/sucess";
	}
	
	@RequestMapping("/searchAll")
	public String searchAll(Model model) {
		List<MemberDto> list = memberDao.searchAll();
		model.addAttribute("list", list);
		return "/search";
	}
	
	@PostMapping("/search")
	public String search(String title, String text, Model model) {
		System.out.println("title = "+title);
		System.out.println("text = "+text);
		List<MemberDto> list = memberDao.search(title, text);
		model.addAttribute("list", list);
		return "/search";
	}
}
