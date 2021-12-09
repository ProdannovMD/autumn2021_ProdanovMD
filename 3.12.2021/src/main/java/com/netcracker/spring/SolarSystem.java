package com.netcracker.spring;

import com.netcracker.spring.annotations.Documented;
import com.netcracker.spring.annotations.NotNull;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;

@Documented(storageFieldName = "nullFields")
public class SolarSystem {
    private static final Logger LOGGER = Logger.getLogger("SolarSystem");

    @NotNull
    private String name;
    private Star star;
    private List<Planet> planets;
    private ApplicationContext applicationContext;
    private List<String> nullFields;

    public SolarSystem(Star star, List<Planet> planets, ApplicationContext applicationContext) {
        this.star = star;
        this.planets = planets;
        this.applicationContext = applicationContext;
    }

    public void init() {
        if (nullFields != null && nullFields.size() > 0) {
            StringJoiner msg = new StringJoiner(", ");
            for (String nullField : nullFields) {
                msg.add(nullField);
            }
            LOGGER.log(Level.WARNING,"NotNull fields are actually null: " + msg);
        }
    }

    @Override
    public String toString() {
        return "SolarSystem{" +
                "name='" + name + '\'' +
                ", star=" + star +
                ", planets=" + planets +
                '}';
    }
}
