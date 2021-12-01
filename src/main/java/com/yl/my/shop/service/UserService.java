package com.yl.my.shop.service;

import com.yl.my.shop.entity.User;

/**
 * @author: yl
 * @version: 1.0
 * @date: 2021-11-28  23:41
 */
public interface UserService {
    /**
     *@Description:根据邮箱和密码获取登录信息
     *@Author: yl
     *@Date: 2021-11-28 23:45
     */
    public User login(String email,String password);
}
