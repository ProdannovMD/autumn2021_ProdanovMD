package november3.classwork.example.factories;

import november3.classwork.example.framework.AfterInitialization;
import november3.classwork.example.framework.StudentServiceInjector;
import november3.classwork.example.services.FirstService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
            try {
                if (aClass.isInterface())
                    continue;
                Object o = aClass.newInstance();
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
