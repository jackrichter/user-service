package com.globalsoftwaresupport.service;

import com.globalsoftwaresupport.model.PatchUserRequest;
import com.globalsoftwaresupport.model.User;

import java.util.List;

public interface UserService {
    public List<User> getUsers();
    public User getUser(Long id);
    public void create(User user);
    public void delete(Long id);
    public void update(User user, PatchUserRequest request);
}
