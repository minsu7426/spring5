package mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ctx.AppCtx;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
	
	Map map = ctx.getBean(Map.class);
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		if(command.equals("/submit.do")) {
			String point = request.getParameter("point");
			double[] juso = map.search(point);
			request.setAttribute("lat", juso[0]);
			request.setAttribute("lng", juso[1]);
			request.setAttribute("point", point);
			RequestDispatcher rd = request.getRequestDispatcher("/view.jsp");
			rd.forward(request, response);
		}
	}
	
	

}
