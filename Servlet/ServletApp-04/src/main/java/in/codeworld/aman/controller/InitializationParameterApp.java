package in.codeworld.aman.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		description = "Working with init parameter", 
		urlPatterns = { "/data" }, 
		initParams = { 
				@WebInitParam(name = "PhoneNo", value = "5475538469", description = "mobileNo"), 
				@WebInitParam(name = "EmailID", value = "aman.soni6200@gmail.com", description = "userId"), 
				@WebInitParam(name = "Username", value = "Aman", description = "Name of the user")
		})
public class InitializationParameterApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RequestProcessing :: InitializationParameterApp.doGet()");
		System.out.println("Config Object details :: "+getServletConfig()); //ServletConfig : ServletData
		System.out.println("Context Object details :: "+getServletContext());//ServletContext : ProjectData
		
		PrintWriter out = response.getWriter();
		out.println("<body align='center' bgcolor='cyan'>");
		out.println("<h1 style='text-align:'center;'>SERVLETCONFIG DATA::"+getServletName()+"</h1>");
		out.println("<table border='1' align='center'>");
		out.println("<tr><th>PARAMETERNAME</th><th>PARAMETERVALUE</th></tr>");
		
//		ServletConfig config = getServletConfig();
//		Enumeration<String> parameterNames = config.getInitParameterNames();
		Enumeration<String> parameterNames = getInitParameterNames();
		while(parameterNames.hasMoreElements()) {
			out.println("<tr>");
			
			String parameterName = (String) parameterNames.nextElement();
//			String parameterValue = config.getInitParameter(parameterName);
			String parameterValue = getInitParameter(parameterName);
			
			out.println("<td>"+parameterName+"</td>");
			out.println("<td>"+parameterValue+"</td>");
			
			out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("</body>");
		out.close();
	}

}
