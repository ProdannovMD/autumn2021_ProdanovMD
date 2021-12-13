package com.example.lesson.repository;

import com.example.lesson.model.Planet;
import org.springframework.data.repository.CrudRepository;

public interface PlanetRepository extends CrudRepository<Planet, Integer> {
}
