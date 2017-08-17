package com.csy.springboot.intereptor;

import com.csy.springboot.annotation.Authorization;
import com.csy.springboot.domain.Token;
import com.csy.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by chenshengyu
 * on 2017/8/17.
 */
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        Token token = new Token();
        String tokenText = request.getHeader("token");
        String id = request.getHeader("id");
        if (tokenText != null && id != null) {
            token.setToken(tokenText);
            token.setUser_id(Long.valueOf(id));
            if (userService.checkToken(token)) {
                return true;
            }
        }

        if (method.getAnnotation(Authorization.class) != null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        return true;
    }
}
