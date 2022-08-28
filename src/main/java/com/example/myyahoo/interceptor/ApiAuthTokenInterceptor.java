package com.example.myyahoo.interceptor;

import com.example.myyahoo.common.AuthToken;
import com.example.myyahoo.common.Constants;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class ApiAuthTokenInterceptor implements HandlerInterceptor {

    public List<String> authPath = Arrays.asList("/api/**/**");
    public List<String> authExPath = Arrays.asList("/api/auth/**","/api/board/list","/api/board/view");

    private String decryptSource="";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  {
        String authToken = request.getHeader("auth-token");
        if(authToken == null) {
            throw new NullPointerException("auth-token값이 존재하지 않습니다.");
        }else{
            decryptSource = AuthToken.decrypt(authToken, Constants.SECREATE_KEY);
            System.out.println(decryptSource);
            if(decryptSource != null) {
                String test[] = decryptSource.split("\\^");
                Date date = new Date();
                Long now = date.getTime() / 1000L;
                if ((now.intValue() - Integer.parseInt(test[1])) > 60 * 60 * 24) {
                    throw new NullPointerException("auth-token값이 정확하지 않습니다.");
                }
            }else{
                throw new NullPointerException("auth-token값이 유효하지 않습니다..");
            }
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
