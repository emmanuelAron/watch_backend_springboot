package com.ltp.contacts.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ltp.contacts.exception.NoContactException;
import com.ltp.contacts.pojo.Contact;
import com.ltp.contacts.service.ContactService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/contact")
    public ResponseEntity<HttpStatus> createContact(@RequestBody Contact contact){
        contactService.saveContact(contact);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/contact/{id}")
    @ResponseBody
    public ResponseEntity<Contact> getContact(@PathVariable String id) {
        Contact contact = null;
        try {
            contact = contactService.getContactById(id);
            return new ResponseEntity<>(contact, HttpStatus.OK);
        } catch (NoContactException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/contact/all")
    @ResponseBody
    public ResponseEntity<List<Contact>> getContacts() {
        List<Contact> contacts = null;
        try {
            contacts = contactService.getContacts();
            return new ResponseEntity<>(contacts, HttpStatus.OK);
        } catch (NoContactException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
   
    @PutMapping("/contact/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable String id, @RequestBody Contact contact){
        try{
        contactService.updateContact(id, contact);
        return new ResponseEntity<Contact>(contactService.getContactById(id),HttpStatus.OK);
        }catch(NoContactException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteContact(@PathVariable String id){
        try{
            contactService.deleteContact(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(NoContactException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
