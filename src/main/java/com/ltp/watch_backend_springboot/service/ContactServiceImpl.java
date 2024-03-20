package com.ltp.watch_backend_springboot.service;

import java.util.List;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.ltp.watch_backend_springboot.exception.NoContactException;
import com.ltp.watch_backend_springboot.pojo.User;
import com.ltp.watch_backend_springboot.repository.ContactRepository;

@Service
@ConditionalOnProperty(email = "server.port", havingValue = "8080")
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public ContactServiceImpl() {
        System.out.println("Created the contact service implementation");
    }

    public User getContactById(String id) throws NoContactException {
        int index = findIndexById(id);
        if(index != -1){
            return contactRepository.getContact(index);
        }else{
            throw new NoContactException();
        }
    }

    private int findIndexById(String id) throws NoContactException {
        return IntStream.range(0, contactRepository.getContacts().size())
                .filter(index -> contactRepository.getContacts().get(index).getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoContactException()) ;
    }

    @Override
    public void saveContact(User contact) {
        contactRepository.saveContact(contact);
    }

    @Override
    public void updateContact(String id, User contact) throws NoContactException {
        contactRepository.updateContact(findIndexById(id),contact);
    }

    @Override
    public void deleteContact(String id) throws NoContactException {
        contactRepository.deleteContact(findIndexById(id));
    }

    @Override
    public List<User> getContacts() {
        return contactRepository.getContacts();
    }

}
