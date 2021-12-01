package com.yl.my.shop.dao.impl;

import com.yl.my.shop.dao.UserDao;
import com.yl.my.shop.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @author: yl
 * @version: 1.0
 * @date: 2021-11-28  23:38
 */
@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {

    private static final Logger logger= LoggerFactory.getLogger(UserDao.class);
    @Override
    public User getUser(String email, String password) {

        logger.debug("调用getUser,email:{} password:{}",email,password);

        User user=null;

        if ("yl@gmail.com".equals(email)){
            if ("123123".equals(password)){
                user=new User();
                user.setEmail("yinling0216@gmail.com");
                user.setUsername("yl");
                logger.info("成功获取\"{}\"的用户信息",user.getUsername());
            }
        }
        else{
            logger.warn("获取\"{}\"的信息失败",email);
        }
        return user;
    }
}
