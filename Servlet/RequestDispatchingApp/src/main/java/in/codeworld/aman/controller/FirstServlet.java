package in.codeworld.aman.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RequestProcessing :: FirstServlet.doGet()");
		System.out.println("Request object name:: "+request.getClass().getCanonicalName());
		System.out.println("Response object name:: "+response.hashCode());
		
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:red; text-align:center;'>Output from FirstServlet...</h1>");
//		out.flush(); //commiting the response
		
		//Setting the attribute
		request.setAttribute("NAME", "PWSKILLS");
		request.setAttribute("TYPE", "EDTECH");
		request.setAttribute("LOCATION", "NOIDA");
		
		//Forwarding the request using R.D(good approach : relativepath)
		RequestDispatcher rd = request.getRequestDispatcher("/second");
		rd.forward(request, response);
		
		System.out.println("\nRequest coming back to :: "+getClass().getName());
		System.out.println("Container ignored this response");
		System.out.println(10/0);
		out.close();
	}

}
