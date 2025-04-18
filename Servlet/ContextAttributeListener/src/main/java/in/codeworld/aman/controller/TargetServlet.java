package in.codeworld.aman.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.codeworld.aman.listener.RequestDemoListener;

/**
 * Servlet implementation class TargetServlet
 */
@WebServlet("/target")
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RequestProcessing -> TargetServlet.doGet()...");
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:blue; text-align:center;'>No of uses using the application :: "+RequestDemoListener.count+"</h1>");
		out.close();
	}

}
