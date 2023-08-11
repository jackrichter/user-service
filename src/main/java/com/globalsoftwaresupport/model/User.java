package com.globalsoftwaresupport.model;

public class User {

    private long id;
    private String firstName;
    private String lasttName;
    private String email;

    public User(Long id, String firstName, String lasttName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lasttName = lasttName;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasttName() {
        return lasttName;
    }

    public void setLasttName(String lasttName) {
        this.lasttName = lasttName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
