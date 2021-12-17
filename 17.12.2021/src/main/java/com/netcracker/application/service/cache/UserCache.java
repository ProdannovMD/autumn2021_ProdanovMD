package com.netcracker.application.service.cache;


import com.netcracker.application.service.model.User;
import com.netcracker.application.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserCache {
    private final Map<Integer, User> users = new HashMap<>();

    private final UserRepository userRepository;

    @Autowired
    public UserCache(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        fillCache();
        return new ArrayList<>(users.values());
    }

    private void fillCache() {
        if(users.isEmpty()) {
            userRepository.findAll().forEach(user -> users.put(user.getId(), user));
        }
    }

    public User getById(Integer id) {
        fillCache();
        return users.get(id);
    }

    public void save(User user) {
        userRepository.save(user);
        users.clear();
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
        users.clear();
    }
}
