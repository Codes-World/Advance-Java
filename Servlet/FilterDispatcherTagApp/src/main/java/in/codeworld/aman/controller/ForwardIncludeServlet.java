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
	
	static {
		System.out.println("LOADING :: ForwardIncludeServlet.class file is loading...");
	}

	public ForwardIncludeServlet() {
        System.out.println("INSTANTIATION :: ForwardIncludeServlet object is instantiated...");
    }
	
	public void init() throws ServletException {
		System.out.println("INTIALIZATION :: ForwardIncludeServlet is initalized...");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("REQUEST PROCESSING :: ForwardIncludeServlet.doFilter()");
		RequestDispatcher rd = request.getRequestDispatcher("./test2");
		rd.include(request, response);
	}

}
