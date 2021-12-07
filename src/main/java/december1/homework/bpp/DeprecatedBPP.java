package december1.homework.bpp;

import december1.homework.annotation.Deprecated;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

@Component
public class DeprecatedBPP implements SmartInstantiationAwareBeanPostProcessor {

    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        if (beanClass.isAnnotationPresent(Deprecated.class)) {
            Deprecated annotation = beanClass.getAnnotation(Deprecated.class);
            try {
                return Class.forName(annotation.value()).getConstructors();
            } catch (ClassNotFoundException ignored) {
            }
        }
        return SmartInstantiationAwareBeanPostProcessor.super.determineCandidateConstructors(beanClass, beanName);
    }
}
