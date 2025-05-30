package in.codeworld.aman.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class DemoFilter
 */
public class DemoFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("FilterLoading :: DemoFilter.class file is loading...");
	}
	
    public DemoFilter() {
        System.out.println("FilterInstantiation :: DemoFilter object is created...");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("FilterDeInstantiation :: DemoFilter.destroy()...");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("FilterRequestProcessing :: DemoFilter.doFilter...");
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:red; text-align:center;'>ADDED BY FILTER BEFORE REQUEST PROCESSING...</h1>");
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		out.println("<h1 style='color:red; text-align:center;'>ADDED BY FILTER AFTER REQUEST PROCESSING...</h1>");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("FilterInitialization :: DemoFilter.init()....");
	}

}
