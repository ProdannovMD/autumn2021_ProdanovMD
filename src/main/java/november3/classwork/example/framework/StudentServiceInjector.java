package november3.classwork.example.framework;

import november3.classwork.example.annotations.Inject;
import november3.classwork.example.factories.Factory;

import java.lang.reflect.Field;
import java.util.Arrays;

public class StudentServiceInjector implements AfterInitialization{
    @Override
    public void initialize(Object o) {
        Arrays.stream(
                o.getClass().getDeclaredFields()
        )
                .filter(field -> field.isAnnotationPresent(Inject.class))
                .forEach(field -> {
                    field.setAccessible(true);
                    try {
                        field.set(
                                o,
                                Factory.getObjects().get(
                                        field.getAnnotation(Inject.class)
                                                .className()
                                )
                        );
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }
}
