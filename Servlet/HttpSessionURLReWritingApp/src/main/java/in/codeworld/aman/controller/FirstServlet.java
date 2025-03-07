package in.codeworld.aman.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test1")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String uname = request.getParameter("name");
		out.println("<body align='center'>");
		out.println("<h1 style='color:green; text-align:center;'>Welcome to CodeWorld.....</h1>");
		//String url="./test2?name="+uname;
		//String encodeURL = response.encodeUrl(url);
		//response.sendRedirect(encodeURL);
		out.println("<a href=./test2?name="+uname+">CLICK HERE TO GET THE NAME</a>");
		out.println("</body>");
		out.close();
	}

}
