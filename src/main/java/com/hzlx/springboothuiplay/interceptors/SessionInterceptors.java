package com.hzlx.springboothuiplay.interceptors;

import com.hzlx.springboothuiplay.entity.SysUserInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * springboot-hui-play
 * 2023/5/23 11:01
 * 星期二
 */
@Component
public class SessionInterceptors implements HandlerInterceptor {

    @Value("${hui_play.session-key}")
    private String sessionKey;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(sessionKey);
        //判断用户对象是否为空，如果为空，返回登录页
        if (userInfo==null){
            //重定向到登录页
            response.sendRedirect("/");
        }

        //不为空的时候，说明用户已经登录了
        //先获取本次请求的uri
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        return true;
    }
}
