package com.scenes.a;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Map;

@Component
public class AutoFitBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 初始化每个bean对象，获取到对象的属性，遍历属性，当存在符合AutoFit注解的时候，执行handleAutoFit
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> aClass = bean.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(AutoFit.class)) {
                if (!field.getType().isInterface()) {
                    throw new BeanCreationException("AutoFit field must be declared as an interface:" + field.getName()
                            + " @Class " + aClass.getName());
                }
                try {
                    handleAutoFit(field, bean, field.getType());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * @param field
     * @param bean
     * @param type
     */
    private void handleAutoFit(Field field, Object bean, Class type) throws IllegalAccessException {
        Map<String, Object> candidates = this.applicationContext.getBeansOfType(type);
        field.setAccessible(true);
        if (candidates.size() > 1) {
            throw new IllegalArgumentException("Find more than 2 beans for type: " + type);
        }
        //给我们关注的对象添加代理
        field.set(bean, BeanProxyFactory.createProxy(field.getAnnotation(AutoFit.class).value(), type, candidates));
//        field.set(bean, candidates.values().iterator().next());
    }
}
