package com.yxy.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JurisdictionFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse rep,FilterChain fc) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		String uri=request.getRequestURI();
		System.out.println("uri="+uri);
//		request.setAttribute("error", "你好");
//		HttpServletResponse response=(HttpServletResponse)rep;
//		PrintWriter pw=response.getWriter();
//		response.setContentType("text/html;charset=GB2312");
//		pw.write("你好");
//		//request.getRequestDispatcher("/index.jsp").forward(req, rep);
		fc.doFilter(req, rep);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
