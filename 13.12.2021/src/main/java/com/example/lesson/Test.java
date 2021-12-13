package com.example.lesson;

import com.example.lesson.model.Planet;
import com.example.lesson.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Component
public class Test {
    ApplicationContext context;

    @Autowired
    public Test(ApplicationContext context) {
        this.context = context;
    }

    @PostConstruct
    public void init() {
        PlanetRepository planetRepository = context.getBean(PlanetRepository.class);
        Optional<Planet> optionalPlanet = planetRepository.findById(1);
        if (optionalPlanet.isPresent()) {
            Planet planet = optionalPlanet.get();
            planet.setPlanetName("Earth");
            planetRepository.save(planet);
        }
        Planet newPlanet = new Planet();
        newPlanet.setPlanetName("Mars");
        newPlanet.setSolarSystemId(1);
        planetRepository.save(newPlanet);

        System.out.println(planetRepository.findAll());
    }
}
