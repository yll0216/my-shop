package com.yl.my.shop.web.interceptor;

import com.yl.my.shop.commons.constant.ConstantUtils;
import com.yl.my.shop.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 配置拦截器
 * @author: yl
 * @version: 1.0
 * @date: 2021-12-2  16:57
 */
public class LoginIterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        User user = (User) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);
        //登陆失败
        if(user==null){
            httpServletResponse.sendRedirect("/login");
        }
        //登录成功则为true，放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
