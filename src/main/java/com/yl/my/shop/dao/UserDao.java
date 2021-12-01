package com.yl.my.shop.dao;

import com.yl.my.shop.entity.User;

/**
 * @author: yl
 * @version: 1.0
 * @date: 2021-11-28  23:36
 */
public interface UserDao {
    /**
     *@Description:根据邮箱和密码获取用户
     *@Author: yl
     *@Date: 2021-11-28 23:45
     */
    public User getUser(String email,String password);
}
