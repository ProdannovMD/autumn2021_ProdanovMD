package december1.homework.bpp;

import december1.homework.annotation.IntRandom;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class InjectRandomIntBPP implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Arrays.stream(bean.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(IntRandom.class))
                .forEach(field -> {
                        field.setAccessible(true);
                        try {
                            field.set(bean, ThreadLocalRandom.current().nextInt());
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                });
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
