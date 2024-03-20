package com.ltp.watch_backend_springboot.service;

import java.util.List;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.ltp.watch_backend_springboot.exception.NoUserException;
import com.ltp.watch_backend_springboot.pojo.User;
import com.ltp.watch_backend_springboot.repository.UserRepository;

@Service
@ConditionalOnProperty(name = "server.port", havingValue = "8080")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository UserRepository;

    public UserServiceImpl() {
        System.out.println("Created the User service implementation");
    }

    public User getUserById(String id) throws NoUserException {
        int index = findIndexById(id);
        if(index != -1){
            return UserRepository.getUser(index);
        }else{
            throw new NoUserException();
        }
    }

    private int findIndexById(String id) throws NoUserException {
        return IntStream.range(0, UserRepository.getUsers().size())
                .filter(index -> UserRepository.getUsers().get(index).getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoUserException()) ;
    }

    @Override
    public void saveUser(User User) {
        UserRepository.saveUser(User);
    }

    @Override
    public void updateUser(String id, User User) throws NoUserException {
        UserRepository.updateUser(findIndexById(id),User);
    }

    @Override
    public void deleteUser(String id) throws NoUserException {
        UserRepository.deleteUser(findIndexById(id));
    }

    @Override
    public List<User> getUsers() {
        return UserRepository.getUsers();
    }

}
