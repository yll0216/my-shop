package com.yl.my.shop.commons.context;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author: yl
 * @version: 1.0
 * @date: 2021-11-29  19:19
 */
@Component
public class SpringContext implements ApplicationContextAware, DisposableBean {

    private final Logger logger= LoggerFactory.getLogger("SpringContext.class");

    private static ApplicationContext applicationContext;
    /**
     *@Description:根据beanId获取实例
     *@Author: yl
     *@Date: 2021-11-30 14:54
     */
    public static <T> T getBean(String beanId){

        return (T) applicationContext.getBean(beanId);
    }
    @Override
    public void destroy() throws Exception {
        logger.debug("清空ApplicationContext");
        applicationContext=null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContext.applicationContext=applicationContext;
    }
    /*//调用工具类判断是否配置完成
    private static void assertContextInjected(){
        Validate.validState(applicationContext==null,"还未在spring-context.xml中配置SpringContext对象");
    }*/
}
