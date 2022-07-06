package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import t1.Dao;
import t1.Dto;

@Controller
public class WebController {
	
	private Dao dao;
	
	@Autowired
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/test/input")
	public String input() {
		return "/test/input";
	}
	
	@PostMapping("/test/printer")
	public String action(HttpServletRequest request, Model model) {
		Dto dto = dao.check(request);
		model.addAttribute("name",dto.getName());
		model.addAttribute("age",dto.getAge());
		return "/test/printer";
	}
	
}
