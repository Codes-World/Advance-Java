package in.codeworld.aman.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LogFilter
 */

public class LogFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;
	private FilterConfig fconfig;

	static {
		System.out.println("LogFilterLoading :: LogFilter.class file is loading...");
	}
	/**
     * @see HttpFilter#HttpFilter()
     */
    public LogFilter() {
    	System.out.println("LogFilterInstamtiation :: LogFilter object is instantiated...");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		fconfig = null;
		System.out.println("LogFilterDeInstantiation :: DemoFilter object is instantiated...");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("LogFilterRequestProcessing :: TargetServlet.doFilter()");
		
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:blue; text-align:center'>ADDED BY LOG FILTER BEFORE REQUEST PROCESSING...</h1>");
		
		ServletContext context = fconfig.getServletContext();
		HttpServletRequest req = (HttpServletRequest) request;
		
		context.log("A request is coming from :: "+req.getRemoteHost()+" for URL "+req.getRequestURI()+" at :: "+new java.util.Date());

		// pass the request along the filter chain
		chain.doFilter(request, response);
		out.println("<h1 style='color:blue; text-align:center'>ADDED BY LOG FILTER AFTER REQUEST PROCESSING...</h1>");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fconfig) throws ServletException {
		this.fconfig = fconfig;
		System.out.println("LogFilterInitilization :: LogFilter is initalized...");
	}

}
