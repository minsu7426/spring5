package t1;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class Dao {
	
	public Dto check(HttpServletRequest request) {
		Dto dto = new Dto();
		dto.setName(request.getParameter("name"));
		dto.setAge(request.getParameter("age"));
		return dto;
	}
}
