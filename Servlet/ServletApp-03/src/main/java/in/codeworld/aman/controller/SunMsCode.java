package in.codeworld.aman.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SunMsCode
 */
@WebServlet("/sunms")
public class SunMsCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("Loading :: SunMsCode.class file is loading...");
	}
	
	public SunMsCode() {
		System.out.println("Instantiation :: SunMsCode-> Zero param...");
	}
	
	public void init() throws ServletException {
		System.out.println("Initialization :: SunMsCode.init()...");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ReuestProcessing :: SunMsCode.doGet()");
		response.setStatus(302);
		response.setHeader("Location", "./oracle");
	}

}
