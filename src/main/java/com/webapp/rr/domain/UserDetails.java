package com.webapp.rr.domain;

import org.springframework.data.neo4j.annotation.QueryResult;

/**
 * Created by Pratyoush on 1/7/2017.
 */
@QueryResult
public class UserDetails {

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private boolean isFriend;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getIsFriend() {
        return isFriend;
    }

    public void setIsFriend(boolean friend) {
        isFriend = friend;
    }
}
