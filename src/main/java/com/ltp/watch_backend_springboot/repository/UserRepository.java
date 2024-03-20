package com.ltp.watch_backend_springboot.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ltp.watch_backend_springboot.pojo.User;

@Repository
public class UserRepository {

    private List<User> Users = new ArrayList<>(Arrays.asList(
            new User("1","john@gmail.com", "john_password", "John Snow"),
            new User("2","tyron@gmail.com" ,"tyron_password", "Tyrion Lannister"),
            new User("3","hound@gmail.com" ,"hound_password", "The Hound")));

    public List<User> getUsers() {
        return Users;
    }

    public User getUser(int index) {
        return Users.get(index);
    }

    public void saveUser(User User) {
        Users.add(User);
    }

    public void updateUser(int index, User User) {
        Users.set(index, User);
    }

    public void deleteUser(int index) {
        Users.remove(index);
    }

}
