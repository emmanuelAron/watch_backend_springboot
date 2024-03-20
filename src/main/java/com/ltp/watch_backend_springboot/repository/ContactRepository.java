package com.ltp.watch_backend_springboot.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ltp.watch_backend_springboot.pojo.User;

@Repository
public class ContactRepository {

    private List<User> contacts = new ArrayList<>(Arrays.asList(
            new User("1","john@gmail.com", "john_password", "John Snow"),
            new User("2","tyron@gmail.com" ,"tyron_password", "Tyrion Lannister"),
            new User("3","hound@gmail.com" ,"hound_password", "The Hound")));

    public List<User> getContacts() {
        return contacts;
    }

    public User getContact(int index) {
        return contacts.get(index);
    }

    public void saveContact(User contact) {
        contacts.add(contact);
    }

    public void updateContact(int index, User contact) {
        contacts.set(index, contact);
    }

    public void deleteContact(int index) {
        contacts.remove(index);
    }

}
