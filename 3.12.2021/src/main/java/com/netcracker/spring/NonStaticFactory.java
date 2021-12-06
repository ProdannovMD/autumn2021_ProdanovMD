package com.netcracker.spring;

public class NonStaticFactory {
    public Planet init() {
        return new Planet("Neptune");
    }
}
