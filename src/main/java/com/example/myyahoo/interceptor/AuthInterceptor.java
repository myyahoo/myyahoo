package com.example.myyahoo.interceptor;

import com.example.myyahoo.common.Constants;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    public List<String> authPath = Arrays.asList("/xxxxx/**");
    public List<String> authExPath = Arrays.asList("/login/**","/resources/**","/board/**","/api/**/**","/error/**");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession httpSession = request.getSession();
        var sessionData = httpSession.getAttribute("id");

        System.out.println("session"+sessionData);
        if(sessionData != null){
            return true;
        }else{
            response.sendRedirect("/login");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
