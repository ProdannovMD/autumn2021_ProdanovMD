package com.netcracker.spring;

import org.springframework.context.ApplicationContext;

import java.util.List;

public class SolarSystem {
    private Star star;
    private List<Planet> planets;
    private ApplicationContext applicationContext;

    public SolarSystem(Star star, List<Planet> planets, ApplicationContext applicationContext) {
        this.star = star;
        this.planets = planets;
        this.applicationContext = applicationContext;
    }

    public void init() {
        System.out.println(applicationContext.getBean(Star.class));
    }

    @Override
    public String toString() {
        return "SolarSystem{" +
                "star=" + star +
                ", planets=" + planets +
                '}';
    }
}
