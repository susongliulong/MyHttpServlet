package com.liulong.filter;

import com.liulong.entry.Reader;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/book")
public class BookFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session=((HttpServletRequest)servletRequest).getSession ();
        Reader reader=(Reader)session.getAttribute ("reader");
        if(reader == null){
            ((HttpServletResponse)servletResponse).sendRedirect ("/login.jsp");
        }else{
            filterChain.doFilter (servletRequest, servletResponse);
        }

    }
    @Override
    public void destroy() {

    }
}