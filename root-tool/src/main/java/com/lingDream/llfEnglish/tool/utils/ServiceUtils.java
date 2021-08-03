package com.lingDream.llfEnglish.tool.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

import static com.lingDream.llfEnglish.tool.utils.SpringBootGetBean.getServiceBean;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-07-25 11:46
 */
@Component
public class ServiceUtils {
    final Underline2Camel underline2Camel;

    public ServiceUtils(Underline2Camel underline2Camel) {
        this.underline2Camel = underline2Camel;
    }

    /**
     * 新增或修改前查询一下,
     * 如果存在,则不再添加,
     * 如果不存在,则执行添加,
     *
     * @param t         表示需要添加的对象,用泛型<T>指定,
     *                  通过该自段,可以自动找到IService的对应bean对象
     * @param fieldName 表示需要查询的属性名称->(该参数会自动:驼峰->下划线)
     * @return 如果值存在, 则返回该值, 如果不存在, 则向数据库添加该值, 并将该值返回
     */
    public <T> T beforeTheSaveOrUpdate(T t, String fieldName) {
        final Class<?> tClass = t.getClass();
        final IService<T> serviceBean = (IService<T>) getServiceBean(tClass);
        String methodName = "get" + captureName(fieldName);
        try {
            final Object invoke = tClass.getMethod(methodName).invoke(t);
            final T one = serviceBean.getOne(new QueryWrapper<T>()
                    .eq(underline2Camel.camel2Underline(fieldName), invoke));
            if (one == null) {
                serviceBean.saveOrUpdate(t);
                return t;
            }
            return one;
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 首字母大定
     */
    public String captureName(String name) {
        char[] cs = name.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }

}
