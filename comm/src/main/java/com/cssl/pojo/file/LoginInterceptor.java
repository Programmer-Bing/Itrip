package com.cssl.pojo.file;

import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        Map<String,Object> adminMap=(Map<String,Object>)request.getSession().getAttribute("admin");

        return false;
    }
}
