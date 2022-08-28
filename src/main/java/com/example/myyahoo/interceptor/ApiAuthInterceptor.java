package com.example.myyahoo.interceptor;

import com.example.myyahoo.exceptions.BoardNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Component
public class ApiAuthInterceptor implements HandlerInterceptor {

    public List<String> authPath = Arrays.asList("/api/**/**");
    public List<String> authExPath = Arrays.asList("");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  {
        String apiKey = request.getHeader("api-key");
        if(apiKey == null) {
            throw new NullPointerException("api-key값이 존재하지 않습니다.");
            //throw new BoardNotFoundException("api-key값이 존재하지 않습니다.");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
