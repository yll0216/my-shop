package com.yl.my.shop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: yl
 * @version: 1.0
 * @date: 2021-12-2  15:15
 */
@Controller
public class MainController {
    /**
     *@Description:跳转到主页
     *@Author: yl
     *@Date: 2021-12-2 15:20
     */
    @RequestMapping(value = "main",method = RequestMethod.GET)
    public String main(){
        return "main";
    }
}
