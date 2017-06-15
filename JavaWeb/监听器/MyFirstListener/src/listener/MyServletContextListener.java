package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener, ServletContextAttributeListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("---------------------MyServletContextListener Destroyed--------------------");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("---------------------MyServletContextListener Initialized--------------------");
		String initParam = sce.getServletContext().getInitParameter("initParam");
		System.out.println("initParam : " + initParam);

	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("MyServletContextListener attributeAdded : " + event.getName());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("MyServletContextListener attributeRemoved : " + event.getName());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("MyServletContextListener attributeReplaced : " + event.getName());
	}

}
