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

@WebFilter(filterName="AsynFilter", asyncSupported=true, value={"/servlet/AsynServlet"}, dispatcherTypes={DispatcherType.ASYNC, DispatcherType.REQUEST})
public class AsynFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("--------------------AsynFilter destroy-----------------------");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("--------------------AsynFilter doFilter start-----------------------");
		arg2.doFilter(arg0, arg1);
		System.out.println("--------------------AsynFilter doFilter end-----------------------");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("--------------------AsynFilter init-----------------------");

	}

}
