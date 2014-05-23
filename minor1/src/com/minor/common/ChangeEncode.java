package com.minor.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ChangeEncode implements Filter {
	private String encoding=null;
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig config) throws ServletException {
		encoding=config.getInitParameter("encode");
		System.out.println(encoding);
	}

}
