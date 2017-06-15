package listener;

import java.util.ArrayList;
import java.util.Date;
import entity.*;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import util.SessionUtil;
import entity.User;

public class MyHttpSessionListener implements HttpSessionListener, HttpSessionAttributeListener {

	public int currentUserNumber = 0;
	public ArrayList<User> userList = null;
	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("------------MyHttpSessionListener sessionCreated------------");
		System.out.println("sessionCreated at " + new Date());
		currentUserNumber++;
		arg0.getSession().getServletContext().setAttribute("currentUserNumber", currentUserNumber);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("------------MyHttpSessionListener sessionDestroyed-----------");
		System.out.println("sessionDestroyed at " + new Date());
		currentUserNumber--;
		if(currentUserNumber < 0)currentUserNumber = 0;
		arg0.getSession().getServletContext().setAttribute("currentUserNumber", currentUserNumber);
		
		
		
		userList = (ArrayList<User>) arg0.getSession().getServletContext().getAttribute("userList");
		User user = (User) SessionUtil.getUserBySessionId(userList, arg0.getSession().getId());
		
		if(user != null){
			userList.remove(user);
		}
		
		
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("MyHttpSessionListener attributeAdded : " + event.getName());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("MyHttpSessionListener attributeRemoved : " + event.getName());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("MyHttpSessionListener attributeReplaced : " + event.getName());
	}

}
