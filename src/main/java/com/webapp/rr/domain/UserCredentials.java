package com.webapp.rr.domain;

import org.springframework.data.neo4j.annotation.QueryResult;

/**
 * Created by Pratyoush on 1/11/2017.
 */
@QueryResult
public class UserCredentials {
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
