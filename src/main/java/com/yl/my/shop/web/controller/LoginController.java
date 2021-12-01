package com.yl.my.shop.web.controller;

import com.yl.my.shop.commons.context.SpringContext;
import com.yl.my.shop.commons.utils.CookieUtils;
import com.yl.my.shop.entity.User;
import com.yl.my.shop.service.UserService;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: yl
 * @version: 1.0
 * @date: 2021-11-29  10:46
 */
public class LoginController extends HttpServlet {

    private UserService userService=SpringContext.getBean("userService");
    private static final String COOKIE_NAME_USER_INFO="userInfo";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userInfo = CookieUtils.getCookieValue(req, COOKIE_NAME_USER_INFO);
        if (!StringUtils.isBlank(userInfo)){
            String[] userInfoArray = userInfo.split(":");
            String email=userInfoArray[0];
            String password=userInfoArray[1];
            req.setAttribute("email",email);
            req.setAttribute("password",password);
            req.setAttribute("checkRemember",true);
        }
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password=req.getParameter("password");
        boolean checkRemember = req.getParameter("checkRemember")==null?false:true;


        User admin = userService.login(email, password);
        //登录成功
        if (admin!=null){
            //成功则保存cookie,设置存储时间为一周
            if (checkRemember){
                CookieUtils.setCookie(req,resp,COOKIE_NAME_USER_INFO,String.format("%s:%s",email,password),7*24*60*60);
            }
            //用户选择不记住,则不保存cookie
            if(!checkRemember){
                CookieUtils.deleteCookie(req,resp,COOKIE_NAME_USER_INFO);
            }
            resp.sendRedirect("/main.jsp");
        }
        //登录失败
        else{
            req.setAttribute("message","用户名或密码错误！");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }
}
