package com.webapp.rr.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.annotation.QueryResult;

@NodeEntity
public class User {

    @GraphId private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String gender;
    private String userId;
    private String username;
    private String password;
    private User() {
        // Empty constructor required as of Neo4j API 2.0.5
    };



    public User(String firstName, String lastName, String email, String address, String age, String gender, String userId, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.userId = userId;
        this.username = username;
        this.password = password;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    /**
     * Neo4j doesn't REALLY have bi-directional relationships. It just means when querying
     * to ignore the direction of the relationship.
     * https://dzone.com/articles/modelling-data-neo4j
     */
    @Relationship(type = "Friend_Of", direction = Relationship.DIRECTION)
    public Set<User> friends;

    @Relationship(type= "Likes", direction = Relationship.OUTGOING)
    public Set<Likes> likesRestaurants;

    /*public void friendOf(User user) {
        if (friends == null) {
            friends = new HashSet<>();
        }
        friends.add(user);
    }*/

    public String toString() {

        return this.firstName + " "
                + this.lastName;
    }

}