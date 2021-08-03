package com.lingDream.llfEnglish.tool.utils;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-07-06 14:49
 */
@Component
public class SpringBootGetBean implements ApplicationContextAware {
    private static ApplicationContext application;
    private static final Map<Class<Object>, Object> serviceMap = new HashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        application = applicationContext;
        setServiceMap();
    }

    public static <T> T getBean(Class<T> clazz) {
        return application.getBean(clazz);
    }

    public static Object getBean(String beanName) {
        return application.getBean(beanName);
    }

    private static void setServiceMap() {
        final String[] beanDefinitionNames = application.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            final Object bean = getBean(beanDefinitionName);
            if (bean instanceof IService) {
                serviceMap.put(((IService<Object>) bean).getEntityClass(), bean);
            }
        }
    }

    public static <T> IService<T> getServiceBean(Class<T> tClass) {
        return (IService<T>) serviceMap.get(tClass);
    }
}
