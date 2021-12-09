package december1.homework.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import december1.homework.annotation.Deprecated;

import java.util.Arrays;

@Component
public class DeprecatedBFPP implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        Arrays.stream(configurableListableBeanFactory.getBeanDefinitionNames())
                .map(configurableListableBeanFactory::getBeanDefinition)
                .forEach(beanDefinition -> {
                    try {
                        Class<?> aClass = Class.forName(beanDefinition.getBeanClassName());
                        if (aClass.isAnnotationPresent(Deprecated.class)) {
                            Deprecated annotation = aClass.getAnnotation(Deprecated.class);
                            beanDefinition.setBeanClassName(annotation.value());
                        }
                    } catch (ClassNotFoundException | NullPointerException ignored) {
                    }
                });
    }
}
