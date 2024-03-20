package com.ltp.watch_backend_springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ltp.watch_backend_springboot.exception.NoUserException;
import com.ltp.watch_backend_springboot.pojo.User;
import com.ltp.watch_backend_springboot.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class UserController {

    @Autowired
    private UserService UserService;

    @PostMapping("/User")
    public ResponseEntity<HttpStatus> createUser(@RequestBody User User){
        UserService.saveUser(User);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/User/{id}")
    @ResponseBody
    public ResponseEntity<User> getUser(@PathVariable String id) {
        User User = null;
        try {
            User = UserService.getUserById(id);
            return new ResponseEntity<>(User, HttpStatus.OK);
        } catch (NoUserException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/User/all")
    @ResponseBody
    public ResponseEntity<List<User>> getUsers() {
        List<User> Users = null;
        try {
            Users = UserService.getUsers();
            return new ResponseEntity<>(Users, HttpStatus.OK);
        } catch (NoUserException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
   
    @PutMapping("/User/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User User){
        try{
        UserService.updateUser(id, User);
        return new ResponseEntity<User>(UserService.getUserById(id),HttpStatus.OK);
        }catch(NoUserException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String id){
        try{
            UserService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(NoUserException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
