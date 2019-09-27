package com.cssl.pojo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response =(HttpServletResponse)servletResponse;
        String users=(String) request.getSession().getAttribute("name");
        String url=request.getRequestURI();
        System.out.println("请求的url:"+url);
        int idx=url.lastIndexOf("/");
        String endWith=url.substring(idx+1);
        System.out.println("endWith:"+endWith);
        if(!endWith.equals("login.html") && users==null){
            response.sendRedirect("login.html");
        }else if(endWith.equals("votelist.html")){
            request.getRequestDispatcher("votelist").forward(request,response);
        }

        filterChain.doFilter(request,response);
    }
}
