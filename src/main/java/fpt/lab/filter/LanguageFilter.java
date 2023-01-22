package fpt.lab.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import fpt.lab.constant.PathConstant;

@WebFilter(urlPatterns = PathConstant.ALL_PATH)
public class LanguageFilter extends HttpFilter{
       

	private static final long serialVersionUID = 1L;

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
