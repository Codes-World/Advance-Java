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
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("LOADING :: TargetServlet.class file is loading...");
	}

	public TargetServlet() {
        System.out.println("INSTANTIATION :: TargetServlet object is instantiated...");
    }
	
	public void init() throws ServletException {
		System.out.println("INTIALIZATION :: TargetServlet is initalized...");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("REQUEST PROCESSING :: TargetServlet.doFilter()");
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:green; text-align:center'>THIS IS A TARGET SERVLET...</h1>");
	}

}
