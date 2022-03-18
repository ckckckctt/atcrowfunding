package com.org.crowd.mvc.interceptor;

import com.aiguigu.crowd.entity.Admin;
import com.org.crowd.constant.CrowdConstant;
import com.org.crowd.exception.AccessForbiddenException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 1.通过request 对象获取 Session 对象
        HttpSession session = request.getSession();
        // 2.尝试从Session域获取Admin对象
        Admin admin =  (Admin) session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN);
        // 3.判断Admin对象是否为空
        if (admin == null){
            throw new AccessForbiddenException(CrowdConstant.MESSAGE_ACCESS_FORBIGAN);
        }
        //若 admin 不为空，则返回 true放行
        return true;
    }
}
