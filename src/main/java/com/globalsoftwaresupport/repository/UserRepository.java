package com.globalsoftwaresupport.repository;

import com.globalsoftwaresupport.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
        users.add(new User("Adam", "Spacey", "adam@gmail.com"));
        users.add(new User("Dan", "Smith", "dan@gmail.com"));
        users.add(new User("Ana", "Heck", "ana@gmail.com"));
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void save(User user) {
//        user.setId((long)users.size());
        this.users.add(user);
    }

    public void delete(Integer id) {
        this.users.remove(id);
    }

    public void update(String userId, User user) {
        this.users.set(Integer.valueOf(userId), user);
    }
}
