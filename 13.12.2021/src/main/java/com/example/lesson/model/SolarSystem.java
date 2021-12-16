package com.example.lesson.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;

public class SolarSystem {
    @Id
    private Integer id;

    private String name;

    @MappedCollection(keyColumn = "ID",idColumn = "SOLAR_SYSTEM_ID")
    private Star star;

    @MappedCollection(keyColumn = "ID", idColumn = "SOLAR_SYSTEM_ID")
    private List<Planet> planets;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }

    @Override
    public String toString() {
        return "SolarSystem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", star=" + star +
                ", planets=" + planets +
                '}';
    }
}
