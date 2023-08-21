package com.globalsoftwaresupport.service;

import com.globalsoftwaresupport.model.PatchUserRequest;
import com.globalsoftwaresupport.model.User;
import com.globalsoftwaresupport.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional          // Solves the problem with delete operation
public class UserServiceImpl implements UserService{

    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return repository.findUserByUserId(id);
    }

    @Override
    public void create(User user) {
        repository.save(user);
    }

    @Override
    public void delete(Long id) {
        repository.deleteUserByUserId(id);
    }

    @Override
    public void update(User user, PatchUserRequest request) {
        // Update User with the values that are present in the request
        updateUser(user, request);

        // Save the updated user
        repository.save(user);
    }

    private void updateUser(User user, PatchUserRequest request) {
        if (request.getFirstName() != null)
            user.setFirstName(request.getFirstName());

        if (request.getLastName() != null)
            user.setLastName(request.getLastName());

        if (request.getEmail() != null)
            user.setEmail(request.getEmail());
    }
}
