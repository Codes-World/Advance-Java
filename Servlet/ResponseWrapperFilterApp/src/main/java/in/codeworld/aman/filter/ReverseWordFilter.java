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
import javax.servlet.http.HttpServletResponse;

import in.codeworld.aman.customize.CustomizedResponse;

/**
 * Servlet Filter implementation class ReverseWordFilter
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/test" })
public class ReverseWordFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("ReverseWordFilterLoading :: ReverseWordFilter.class file is loading...");
	}

	/**
     * @see HttpFilter#HttpFilter()
     */
    public ReverseWordFilter() {
    	System.out.println("ReverseWordFilterInstantiation :: ReverseWordFilter object is instantiated...");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("ReverseWordFilterDeInstantiation :: ReverseWordFilter object is instantiated...");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("ReverseWordFilterRequestProcessing :: ReverseWordFilter.doFilter()");

		CustomizedResponse resp = new CustomizedResponse((HttpServletResponse) response);
		
		// pass the request along the filter chain
		chain.doFilter(request, resp);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("ReverseWordFilterInitilization :: ReverseWordFilter is initalized...");
	}

}
