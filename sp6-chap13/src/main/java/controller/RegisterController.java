package controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.DuplicateMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@Controller
public class RegisterController {

	private MemberRegisterService memberRegisterService;
	
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}
	
	@RequestMapping("/register/step1")
	public String handleStep1() {
		return "/register/step1";
	}
	
	@PostMapping("/register/step2")
	public String handleStep2(
			//form: taglib를 사용하면 RequestParam에 Model 매개변수를 추가해준다.
			@RequestParam(value = "agree", defaultValue = "false") Boolean agree, Model model) {
		if(!agree) {
			return "/register/step1";
		}
		//form: taglib를 사용하면 model을 addAttribute 해준다.
		model.addAttribute("registerRequest", new RegisterRequest());
		return "/register/step2";
	}
	
//	@PostMapping("/register/step2")
//	public String handleStep2(HttpServletRequest request) {
//		String agreeParam = request.getParameter("agree");
//		if(agreeParam == null || !agreeParam.equals("true")) {
//			return "/step1";
//		}
//		return "/register/step2";
//	}
	
	@GetMapping("/register/step2")
	public String handleStep2Get() {
		return "redirect:/register/step1";
	}
	
	@PostMapping("/register/step3")
	public String handleStep3(@Valid RegisterRequest regReq, Errors errors) {
		new RegisterRequestValidator().validate(regReq, errors);
		if (errors.hasErrors())
			return "register/step2";

		try {
			memberRegisterService.regist(regReq);
			return "register/step3";
		} catch (DuplicateMemberException ex) {
			errors.rejectValue("email", "duplicate");
			return "register/step2";
		}
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new RegisterRequestValidator());
	}
}
