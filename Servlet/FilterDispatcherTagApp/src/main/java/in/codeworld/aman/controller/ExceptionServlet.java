package in.codeworld.aman.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TargetServlet
 */
public class ExceptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	static {
		System.out.println("ExceptionServlet.class file is loading...");
	}
	
	public ExceptionServlet() {
		System.out.println("ExceptionServletInstantiation :: ExceptionServlet object is created...");
	}
	
	public void init() throws ServletException {
		System.out.println("ExceptionServletInitialization :: ExceptionServlet.init()....");
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ExceptionServletRequestProcessing :: ExceptionServlet.doGet()....");
		PrintWriter out = response.getWriter();
		out.println(10/0);
		
	}

}
