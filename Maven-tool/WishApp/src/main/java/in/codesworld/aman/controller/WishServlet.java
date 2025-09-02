package in.codesworld.aman.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WishServlet
 */
@WebServlet("/wish")
public class WishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter cw = response.getWriter();
		LocalDateTime dt = LocalDateTime.now();
		int hour = dt.getHour();
		
		cw.println("<h1><center>Today date and time is :: "+dt+"</center></h1>");
		if(hour < 12) {
			cw.println("<h2><center>Good Morning</center></h2>");
		}else if(hour < 16) {
			cw.println("<h2><center>Good Afternoon</center></h2>");
		}else if(hour < 20) {
			cw.println("<h2><center>Good Evening</center></h2>");
		}else {
			cw.println("<h2><center>Good night</center></h2>");
		}
		
		cw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
