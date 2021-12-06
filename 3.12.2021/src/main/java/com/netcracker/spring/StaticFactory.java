package com.netcracker.spring;

import java.util.ArrayList;
import java.util.List;

public class StaticFactory {
    public static Planet getPlanet() {
        return new Planet("Venus");
    }

    public static List<Planet> getPlanets(List<String> names) {
        List<Planet> planets = new ArrayList<>();
        for (String name : names) {
            planets.add(new Planet(name));
        }
        return planets;
    }
}
