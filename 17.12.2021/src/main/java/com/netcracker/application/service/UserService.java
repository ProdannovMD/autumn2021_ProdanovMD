package com.netcracker.application.service;

import com.netcracker.application.service.cache.UserCache;
import com.netcracker.application.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Objects;

@Component
public class UserService {

    private final UserCache userCache;

    @Autowired
    public UserService(UserCache userCache) {
        this.userCache = userCache;
    }

    public List<User> getAll() {
        return userCache.getAll();
    }

    public User getById(Integer id) {
        return userCache.getById(id);
    }

    public void create(User user) {
        userCache.save(user);
    }

    public void update(Integer id, User user) {
        User userForUpdate = userCache.getById(id);
        if (Objects.isNull(userForUpdate)) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        if (Objects.nonNull(user.getName()))
            userForUpdate.setName(user.getName());
        if (Objects.nonNull(user.getEmail()))
            userForUpdate.setEmail(user.getEmail());
        if (Objects.nonNull(user.getPassword()))
            userForUpdate.setPassword(user.getPassword());

    }

    public void delete(Integer id) {
        userCache.delete(id);
    }
}
