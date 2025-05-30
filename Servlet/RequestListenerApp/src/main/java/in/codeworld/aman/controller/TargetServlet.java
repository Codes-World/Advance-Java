package in.codeworld.aman.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.codeworld.aman.listener.RequestDemoListener;

/**
 * Servlet implementation class TargetServlet
 */
@WebServlet(urlPatterns = {"/target"}, loadOnStartup = 1)
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("TargetServlet Loading :: TargetServlet.class file is loading...");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TargetServlet() {
        System.out.println("TargetServletInstanttiation :: TargetServlet object is created...");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("TargetServletInitialization :: TargetServlet.init()...");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TargetServletRequestProcessing :: TargetServlet.doGet()...");
		System.out.println("Request Object address is :: "+request.hashCode());
		System.out.println("Response Object address is :: "+response.hashCode());
		System.out.println("Servlet Object address is :: "+this.hashCode());
		System.out.println("Thread information is :: "+Thread.currentThread().hashCode());
		
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:green; text-align:center;'>REQUEST COMING TO TARGETSERVLET...</h1>");
		out.println("<h1 style='color:green; text-align:center;'>The no of hits for the webapplications is :: "+RequestDemoListener.count+"</h1>");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		out.close();

	}

}
