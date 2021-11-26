package november26.classwork;

import november26.classwork.annotations.Bean;
import november26.classwork.exceptions.MultipleBeansException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApplicationContext {
    private static final List<Object> beans = new ArrayList<>();

    public static void init(Class<?> clazz) {
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.isAnnotationPresent(Bean.class)) {
                declaredMethod.setAccessible(true);
                try {
                    Object result = declaredMethod.invoke(null);
                    beans.add(result);
                } catch (IllegalAccessException | InvocationTargetException ignore) { }
                declaredMethod.setAccessible(false);
            }
        }
    }

    public static  <T> T getBean(Class<T> tClass) throws MultipleBeansException {
        Stream<Object> beanStream = beans.stream().filter(o -> (o != null) && tClass.isAssignableFrom(o.getClass()));
        long count = beanStream.count();
        if (count > 1)
            throw new MultipleBeansException();
        return (T) beanStream.findFirst().get();
    }

    public static  <T> List<T> getBeans(Class<T> tClass) {
        return (List<T>) beans.stream().filter(o -> (o != null) &&  tClass.isAssignableFrom(o.getClass())).collect(Collectors.toList());
    }
}
