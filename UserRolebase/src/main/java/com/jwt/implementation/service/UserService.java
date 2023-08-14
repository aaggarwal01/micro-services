package com.jwt.implementation.service;

import com.jwt.implementation.model.User;

import java.util.List;

public interface UserService {
    User readUser();

    User updateUser(User user);

    void deleteUser();

    User getLoggedInUser();
    List<User> getAllUsers();
    public boolean emailExists(String email);


}
