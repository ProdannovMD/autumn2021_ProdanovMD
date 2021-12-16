package com.example.lesson.repository;

import com.example.lesson.model.SolarSystem;
import org.springframework.data.repository.CrudRepository;

public interface SolarSystemRepository extends CrudRepository<SolarSystem, Integer> {
}
