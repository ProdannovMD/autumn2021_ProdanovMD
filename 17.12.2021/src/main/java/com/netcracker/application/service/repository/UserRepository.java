package com.netcracker.application.service.repository;

import com.netcracker.application.service.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
