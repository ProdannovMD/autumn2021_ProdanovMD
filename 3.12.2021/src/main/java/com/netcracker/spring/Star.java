package com.netcracker.spring;

public class Star {
    private String name;

    public Star(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Star{" +
                "name='" + name + '\'' +
                '}';
    }
}
