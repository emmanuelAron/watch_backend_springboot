package com.ltp.watch_backend_springboot.service;

import java.util.List;

import com.ltp.watch_backend_springboot.exception.NoUserException;
import com.ltp.watch_backend_springboot.pojo.User;

public interface UserService {
    User getUserById(String id) throws NoUserException;
    void saveUser(User User);
    void updateUser(String id, User User) throws NoUserException;
    void deleteUser(String id) throws NoUserException;
    List<User> getUsers() throws NoUserException;

}
