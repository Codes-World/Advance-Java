package in.codeworld.aman.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TargetServlet
 */
public class ForwardIncludeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	static {
		System.out.println("ForwardIncludeServlet.class file is loading...");
	}
	
	public ForwardIncludeServlet() {
		System.out.println("ForwardIncludeServletInstantiation :: ForwardIncludeServlet object is created...");
	}
	
	public void init() throws ServletException {
		System.out.println("ForwardIncludeServletInitialization :: ForwardIncludeServlet.init()....");
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ForwardIncludeServletRequestProcessing :: ForwardIncludeServlet.doGet()....");
		RequestDispatcher rd = request.getRequestDispatcher("./test2");
		rd.forward(request, response);
		
	}

}
