package november3.homework.factories;

import november3.homework.annotations.Priority;
import november3.homework.framework.AfterInitialization;
import november3.homework.framework.StudentServiceInjector;
import november3.homework.services.StudentService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Factory {
    private static Factory instance;
    private static Map<String, Object> classNameToObject = new HashMap<>();
    private static List<AfterInitialization> initializations = new ArrayList<AfterInitialization>() {
        {
            add(new StudentServiceInjector());
        }
    };

    private Factory(Path path) throws IOException, InstantiationException, IllegalAccessException {
        List<Class<?>> classes = Files
                .list(path)
                .map(p -> {
                    return p.subpath(4, p.getNameCount()).toString().replace(".java", "")
                            .replace("\\", ".");
                })
                .map(pathToClass -> {
                    try {
                        return Class.forName(pathToClass);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.toList());

        initialization(classes);

        afterInitialization();

    }

    private void initialization(List<Class<?>> classes){
        for (Class<?> aClass : classes) {
            Object o;
            try {
                if (aClass.isInterface()) {
                    List<Class<?>> implementations = classes.stream()
                            .filter(c -> StudentService.class.isAssignableFrom(c) && !c.isInterface())
                            .filter(c -> c.isAnnotationPresent(Priority.class))
                            .collect(Collectors.toList());
                    if (implementations.size() == 0)
                        throw new InstantiationException(
                                "No implementation for " +
                                        aClass.getSimpleName() +
                                        " interface with @Priority annotation"
                        );

                    implementations.sort((c1, c2) -> {
                        int priority1 = c1.getAnnotation(Priority.class).value();
                        int priority2 = c2.getAnnotation(Priority.class).value();
                        return Integer.compare(priority1, priority2);
                    });

                    Class<?> priorityClass = implementations.get(0);

                    if (
                            implementations.size() > 1 &&
                                    priorityClass.getAnnotation(Priority.class).value() ==
                                            implementations.get(1).getAnnotation(Priority.class).value()
                    ) {
                            throw new InstantiationException(
                                    "More than one implementation with highest priority for " +
                                            aClass.getSimpleName() +
                                            " interface"
                            );
                    }

                    o = priorityClass.newInstance();
                } else {
                    o = aClass.newInstance();
                }
                classNameToObject.put(aClass.getSimpleName(), o);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private void afterInitialization() {
        for (Object value : classNameToObject.values()) {
            initializations.forEach(init -> init.initialize(value));
        }
    }

    public static Factory getInstance(Path path) throws IOException, InstantiationException, IllegalAccessException {
        if (instance == null)
            instance = new Factory(path);

        return instance;
    }

    private static void initialize() {

    }

    public static Map<String, Object> getObjects() {
        return classNameToObject;
    }

}
