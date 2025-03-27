package in.codeworld.aman.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayServlet
 */
@WebServlet("/test")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("DisplayServlet Loading :: DisplayServlet.class file is loading...");
	}
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	
	public DisplayServlet() {
    	System.out.println("DisplayServletInstantiation :: DisplayServlet object is instantiated...");
    }
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("DisplayServletInitialization :: DisplayServlet is initalized...");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DisplayServletRequestProcessing :: DisplayServlet.doFilter()");
		String data = request.getParameter("name");
		
    	PrintWriter out = response.getWriter();
    	System.out.println("Out is of type :: "+out.getClass().getName());
    	
    	out.println("<body align='center;'>");
    	out.println("<h1 style='color: red; text-align: center;'>");
    	out.println(data);
    	out.println("</h1>");
    	out.println("</body>");
	}
	
	@Override
    public void destroy() {
    	System.out.println("DisplayServletDeInstantiation :: DisplayServlet.destroy()...");
    }

}
