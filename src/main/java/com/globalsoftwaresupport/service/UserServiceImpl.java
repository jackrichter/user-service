package com.globalsoftwaresupport.service;

import com.globalsoftwaresupport.model.PatchUserRequest;
import com.globalsoftwaresupport.model.User;
import com.globalsoftwaresupport.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getUsers() {
        return repository.getUsers();
    }

    @Override
    public User getUser(String userId) {
        return repository.getUsers().get(Integer.valueOf(userId));
    }

    @Override
    public void create(User user) {
        repository.save(user);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Override
    public void update(String userId, PatchUserRequest request) {
        User user = repository.getUsers().get(Integer.valueOf(userId));

        // Update the values that are present in the request
        if (request.getFirstName() != null)
            user.setFirstName(request.getFirstName());

        if (request.getLasttName() != null)
            user.setLastName(request.getLasttName());

        if (request.getEmail() != null)
            user.setEmail(request.getEmail());

        // Save the user
        repository.update(userId, user);
    }
}
