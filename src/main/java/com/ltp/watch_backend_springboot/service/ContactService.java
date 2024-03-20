package com.ltp.contacts.service;

import com.ltp.contacts.pojo.Contact;

import java.util.List;

import com.ltp.contacts.exception.NoContactException;

public interface ContactService {
    Contact getContactById(String id) throws NoContactException;
    void saveContact(Contact contact);
    void updateContact(String id, Contact contact) throws NoContactException;
    void deleteContact(String id) throws NoContactException;
    List<Contact> getContacts() throws NoContactException;

}
