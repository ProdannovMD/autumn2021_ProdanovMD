package com.netcracker.application.service.cache;


import com.netcracker.application.service.model.User;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class UserCache {
    private final Map<Integer, User> users = new HashMap<>();

    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    public User getById(Integer id) {
        return users.get(id);
    }

    public void save(User user) {
        if (Objects.isNull(user.getId())) {
            user.setId(ThreadLocalRandom.current().nextInt());
        }
        users.put(user.getId(), user);
    }

    public void delete(Integer id) {
        users.remove(id);
    }
}
