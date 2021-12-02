package com.yl.my.shop.web.controller;

import com.yl.my.shop.commons.constant.ConstantUtils;
import com.yl.my.shop.entity.User;
import com.yl.my.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;

/**
 * 登录逻辑
 * @author: yl
 * @version: 1.0
 * @date: 2021-12-2  11:05
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value={"","login"},method = RequestMethod.GET)
    //失败时跳转到login
    public String login(){
        return "login";
    }
    //@RequestParam(Request==true)调用方法必须请求参数
    @RequestMapping(value="login",method = RequestMethod.POST)
    public String login(@RequestParam(required=true) String email, @RequestParam(required = true) String password, HttpServletRequest httpServletRequest) {
        User user = userService.login(email, password);
        //登录失败
        if (user == null) {
            return login();
        }
        //登录成功
        else {
            //将登录信息放入会话
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER,user);
            return "redirect:/main";
        }


    }
}
