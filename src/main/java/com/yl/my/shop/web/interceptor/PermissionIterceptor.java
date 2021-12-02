package com.yl.my.shop.web.interceptor;

import com.yl.my.shop.commons.constant.ConstantUtils;
import com.yl.my.shop.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限拦截器
 * @author: yl
 * @version: 1.0
 * @date: 2021-12-2  21:28
 */
public class PermissionIterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //判断是否是以login结尾的请求
        if (modelAndView.getViewName().endsWith("login")){

            User user = (User) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);

            if (user!=null){
                httpServletResponse.sendRedirect("/main");
            }
        }

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
