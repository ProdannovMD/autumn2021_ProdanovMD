package november26.homework;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class ApplicationContext {
    private final Path ROOT = Paths.get("src", "main", "java").toAbsolutePath();
    private Map<String, Object> beans = new HashMap<>();
    private Map<String, Supplier<Object>> prototypes = new HashMap<>();

    public void init(Path path) {
        if (Files.exists(path) && Files.isRegularFile(path)) {
            path = path.toAbsolutePath();
            String pathString = path.subpath(ROOT.getNameCount(), path.getNameCount()).toString();
            int idx = pathString.lastIndexOf(".");
            pathString = pathString.substring(0, idx).replace(File.separatorChar, '.');
            Class<?> clazz;
            try {
                clazz = Class.forName(pathString);
                init(clazz);
            } catch (ClassNotFoundException ignored) {
            }
        } else if (Files.exists(path)) {
            try {
                Path finalPath = path;
                Files.walk(path).forEach(childPath -> {
                    if (!finalPath.equals(childPath)) {
                        init(childPath);
                    }
                });
            } catch (IOException ignored) {
            }
        }
    }

    public void init(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();

        List<Method> methodList = Arrays.stream(methods)
                .sorted(Comparator.comparing(method -> method.getParameters().length))
                .collect(Collectors.toList());
        for (Method method : methodList) {
            if (method.isAnnotationPresent(Bean.class)) {
                method.setAccessible(true);
                Object[] parameters = new Object[method.getParameters().length];
                for (int i = 0; i < method.getParameters().length; i++) {
                    if (List.class.equals(method.getParameters()[i].getType())) {
                        parameters[i] = getBeans(
                                ((Class)((ParameterizedType) method
                                        .getParameters()[i]
                                        .getParameterizedType())
                                        .getActualTypeArguments()[0])
                        );
                    } else {
                        parameters[i] = getBean(method.getParameters()[i].getType());
                    }
                }
                String name;
                if ("".equals(method.getAnnotation(Bean.class).value())) {
                    name = method.getName();
                } else {
                    name = method.getAnnotation(Bean.class).value();
                }
                if (method.isAnnotationPresent(Prototype.class))
                    prototypes.put(name, () -> {
                        try {
                            return method.invoke(null, parameters);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            return null;
                        }
                    });
                else {
                    try {
                        beans.put(name, method.invoke(null, parameters));
                    } catch (IllegalAccessException | InvocationTargetException ignored) {
                    }
                }

                method.setAccessible(false);
            }
        }
    }

    public void init(Object o) {
        init(o, o.getClass().getSimpleName());
    }

    public void init(Object o, String name) {
        Class<?> clazz = o.getClass();
        if (clazz.isAnnotationPresent(Bean.class)) {
            beans.put(name, o);
        }
    }

    public <T> T getBean(Class<T> clazz) {
        Optional<Object> optional = beans.values().stream().filter(object -> clazz.isAssignableFrom(object.getClass())).findFirst();
        if (optional.isPresent())
            return (T) optional.get();
        else
            return (T) prototypes.values().stream().map(f -> f.get()).filter(object -> clazz.isAssignableFrom(object.getClass())).findFirst().get();
    }

    public <T> List<T> getBeans(Class<T> clazz) {
        List<T> result = (List<T>) beans.values().stream().filter(object -> clazz.isAssignableFrom(object.getClass())).collect(Collectors.toList());
        result.addAll(
                (List<T>) prototypes.values().stream().map(f -> f.get()).filter(object -> clazz.isAssignableFrom(object.getClass())).collect(Collectors.toList())
        );
        return result;
    }

    public <T> T getBean(String name, Class<T> clazz) {
        if (beans.containsKey(name))
            return (T) beans.get(name);
        else
            return (T) prototypes.get(name).get();
    }
}
