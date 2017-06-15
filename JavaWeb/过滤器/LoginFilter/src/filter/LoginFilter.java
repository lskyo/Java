package filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName="LoginFilter", value={"/*"}, initParams={
		@WebInitParam(name = "noLoginPaths", value = "index.jsp;fail.jsp;LoginServlet"), 
		@WebInitParam(name = "charset", value = "GBK")})
public class LoginFilter implements Filter {

	FilterConfig config;
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession session = request.getSession();
		
		String noLoginPaths = config.getInitParameter("noLoginPaths");
		String charset = config.getInitParameter("charset");
		if(charset==null || "".equals(charset)){
			charset = "GBK";
		}
		request.setCharacterEncoding(charset);		
		
		if(noLoginPaths!=null){
			String[] strArray = noLoginPaths.split(";");
			for (int i = 0; i < strArray.length; i++) {
				
				if(strArray[i]==null || "".equals(strArray[i]))continue;
				
				if(request.getRequestURI().indexOf(strArray[i])!=-1 ){
					arg2.doFilter(arg0, arg1);
					return;
				}
			}
		}
		
		
		
		
		if(session.getAttribute("username")!=null){
			arg2.doFilter(arg0, arg1);
		}else{
			response.sendRedirect("index.jsp");
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		config = arg0;
	}

}
