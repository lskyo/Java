package listener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import util.SessionUtil;
import entity.User;

public class MyServletRequestListener implements ServletRequestListener, ServletRequestAttributeListener {

	ArrayList<User> userList = null;
	
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("------------MyServletRequestListener requestDestroyed------------");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("------------MyServletRequestListener requestInitialized------------");
		String name = arg0.getServletRequest().getParameter("name");
		if(name != null){
			System.out.println("name : " + name);
		}
		
		
		userList = (ArrayList<User>)arg0.getServletContext().getAttribute("userList");
		if(userList == null){
			userList = new ArrayList<User>();
		}
		
		
		HttpServletRequest request = (HttpServletRequest) arg0.getServletRequest();
		String sessionId = request.getSession().getId();
		User user = (User) SessionUtil.getUserBySessionId(userList, sessionId);
		
		if(user == null){
			user = new User();
			user.setSessionId(sessionId);
			user.setFirstTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			user.setIpAddr(request.getRemoteAddr());
			userList.add(user);
		}
		
		arg0.getServletContext().setAttribute("userList", userList);
		
	}

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("MyServletRequestListener attributeAdded : " + srae.getName());
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("MyServletRequestListener attributeRemoved : " + srae.getName());
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("MyServletRequestListener attributeReplaced : " + srae.getName());
	}

}
