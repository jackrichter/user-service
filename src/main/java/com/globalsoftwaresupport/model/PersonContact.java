package com.globalsoftwaresupport.model;

import javax.persistence.Embeddable;

@Embeddable
public class PersonContact {

    private String gender;
    private String phone;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
