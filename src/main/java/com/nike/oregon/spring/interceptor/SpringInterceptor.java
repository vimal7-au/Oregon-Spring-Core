package com.nike.oregon.spring.interceptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


@Component
public class SpringInterceptor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {

        if (beanName.contains("CruiseService")) {
            System.out.println("BeforeInitialization : " + beanName);
        }
        return bean;
    }
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        if (beanName.equals("CruiseService")) {
            System.out.println("AfterInitialization : " + beanName);
        }
        return bean;
    }
}
