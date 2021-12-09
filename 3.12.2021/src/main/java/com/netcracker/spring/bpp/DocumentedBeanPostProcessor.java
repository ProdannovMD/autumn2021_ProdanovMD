package com.netcracker.spring.bpp;

import com.netcracker.spring.annotations.Documented;
import com.netcracker.spring.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Component
public class DocumentedBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String name) throws BeansException {
        Class<?> aClass = bean.getClass();
        if (aClass.isAnnotationPresent(Documented.class)) {
            try {

                Documented annotation = aClass.getAnnotation(Documented.class);
                Field storage = aClass.getDeclaredField(annotation.storageFieldName());
                storage.setAccessible(true);
                if (!List.class.isAssignableFrom(storage.getType()))
                    return bean;

                List<String> nullFields = new ArrayList<>();

                Field[] declaredFields = aClass.getDeclaredFields();
                for (Field declaredField : declaredFields) {
                    declaredField.setAccessible(true);
                    if (declaredField.isAnnotationPresent(NotNull.class) && declaredField.get(bean) == null) {
                        nullFields.add(declaredField.getName());
                    }
                }
                storage.set(bean, nullFields);
            } catch (NoSuchFieldException | IllegalAccessException ignored) {
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String name) throws BeansException {
        return bean;
    }
}
