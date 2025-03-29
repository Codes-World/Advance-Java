package in.codeworld.aman.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class RequestServletAttributeListener
 *
 */
@WebListener
public class RequestServletAttributeListener implements ServletRequestAttributeListener {
	
	static {
		System.out.println("RequestServletAttributeListenerLoading :: RequestServletAttributeListener.class file is loading...");
	}

    /**
     * Default constructor. 
     */
    public RequestServletAttributeListener() {
    	System.out.println("RequestServletAttributeListener Instantiation....");
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
         System.out.println(srae.getName()+" object is removed...");
    }

	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    	System.out.println(srae.getName()+" object is added...");
    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	System.out.println(srae.getName()+" object is updated..."+"\n");
    }
	
}
