package com.netcracker.spring;

public class Planet {
    private String name;
    private String oldName = "None";

    public Planet(String name) {
        this.name = name;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public void setNonExistedField(String name) {
        System.out.println("I dont exist");
    }

    public void init() {
        System.out.println("Read some json value");
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", oldName='" + oldName + '\'' +
                '}';
    }
}
