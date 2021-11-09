package november3.homework.framework;

import november3.homework.annotations.Inject;
import november3.homework.factories.Factory;

import java.util.Arrays;

public class StudentServiceInjector implements AfterInitialization {
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
                                Factory.getObjects().getOrDefault(
                                        field.getType().getSimpleName(),
                                        null
                                )
                        );
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }
}
