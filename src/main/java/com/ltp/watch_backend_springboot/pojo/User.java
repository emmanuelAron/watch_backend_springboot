package com.ltp.watch_backend_springboot.pojo;

import java.util.UUID;

public class User {

    private String id;
    private String email;
    private String password;
    private String name;
    
    
    /**************
     * Constructors :
     *
     ***************/
    public User(String id, String email, String password, String name) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    // public User(String id, String name, String password) {
    //     this.id = id;
    //     this.name = name;
    //     this.password = password;
    // }

    public User() {
        this.id = UUID.randomUUID().toString();
    }

    /**************
     * Setters and getters :
     *
     ***************/

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
