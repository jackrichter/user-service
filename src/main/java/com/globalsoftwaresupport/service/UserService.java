package com.globalsoftwaresupport.service;

import com.globalsoftwaresupport.model.PatchUserRequest;
import com.globalsoftwaresupport.model.User;

import java.util.List;

public interface UserService {
    public List<User> getUsers();
    public User getUser(String userId);
    public void create(User user);
    public void delete(Integer id);
    public void update(String userId, PatchUserRequest request);
}
