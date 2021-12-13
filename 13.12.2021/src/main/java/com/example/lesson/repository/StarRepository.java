package com.example.lesson.repository;

import com.example.lesson.model.Star;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

public interface StarRepository extends CrudRepository<Star, Integer> {
}
