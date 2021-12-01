package com.yl.my.shop.service.impl;

import com.yl.my.shop.commons.context.SpringContext;
import com.yl.my.shop.dao.UserDao;
import com.yl.my.shop.dao.impl.UserDaoImpl;
import com.yl.my.shop.entity.User;
import com.yl.my.shop.service.UserService;
import org.springframework.stereotype.Service;

import javax.swing.*;

/**
 * @author: yl
 * @version: 1.0
 * @date: 2021-11-28  23:46
 */
@Service(value="userService")

public class UserServiceImpl implements UserService {

    private UserDao userDao=SpringContext.getBean("userDao");

    @Override
    public User login(String email, String password) {
        return userDao.getUser(email,password);
    }
}
