package com.example.lesson;

import com.example.lesson.repository.SolarSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Homework {
    private ApplicationContext applicationContext;

    @Autowired
    public Homework(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void init() {
        SolarSystemRepository solarSystemRepository = applicationContext.getBean(SolarSystemRepository.class);
        solarSystemRepository.findAll().forEach(System.out::println);
    }
}
