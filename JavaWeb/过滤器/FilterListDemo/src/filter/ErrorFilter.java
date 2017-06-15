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

@WebFilter (filterName="ErrorFilter", value={"/error.jsp"}, dispatcherTypes={DispatcherType.ERROR})
public class ErrorFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("--------------------ErrorFilter destroy-----------------------");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("--------------------ErrorFilter doFilter start-----------------------");
		arg2.doFilter(arg0, arg1);
		System.out.println("--------------------ErrorFilter doFilter end-----------------------");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("--------------------ErrorFilter init-----------------------");
	}

}
