package org.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.demo.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private Map<Integer, User> users = new HashMap<Integer, User>();

    @PostConstruct
    public void setup() {
        users.put(1, new User(1, "Mert Caliskan"));
        users.put(2, new User(2, "Kenan Sevindik"));
    }

    public void save(User user) {
        users.put(user.getId(), user);
    }

    public List<User> findAll() {
        return new ArrayList<User>(users.values());
    }

    public User find(int id) {
        return users.get(id);
    }

    public void update(int id, User user) {
        users.put(id, user);
    }

    public void delete(int id) {
        users.remove(id);
    }
}
