package in.codeworld.aman.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class DemoFilter
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/target" })
public class DemoFilter extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static {
		System.out.println("DemoFilter Loading :: DemoFilter.class file is loading...");
	}

	/**
     * @see HttpFilter#HttpFilter()
     */
    public DemoFilter() {
    	System.out.println("DemoFilterInstanttiation :: DemoFilter object is created...");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("DemoFilterDeinitialization :: DemoFilter.init()...");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("DemoFilterRequestProcessing :: DemoFilter.doFilter()..");

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("DemoFilterInitialization :: DemoFilter.init()...");
	}

}
