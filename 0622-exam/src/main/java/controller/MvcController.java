package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import config.AppCtx;
import spring.Sub;

@Component
//@ComponentScan(basePackages = "spring")
public class MvcController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
	
	private Sub sub = ctx.getBean(Sub.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		if(command.equals("/submit.do")) {
			submit(request);
			RequestDispatcher rd = request.getRequestDispatcher("/view.jsp");
			rd.forward(request, response);
		}
	}
	
	public void submit(HttpServletRequest request) {
		String map = request.getParameter("map");
		double[] juso = sub.jusoSearch(map); 
		request.setAttribute("lat", juso[0]);
		request.setAttribute("lng", juso[1]);
		request.setAttribute("map", map);
	}
	
}
