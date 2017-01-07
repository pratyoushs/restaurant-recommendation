package com.webapp.rr.domain;

import org.neo4j.ogm.annotation.*;

/**
 * Created by Pratyoush on 12/30/2016.
 */
@RelationshipEntity(type = "Likes")
public class Likes {
    @GraphId Long id;
    @StartNode
    User user;
    @EndNode
    Restaurant restaurant;

    String rating;

    public String toString(){
        return user.toString() + " -likes- " + restaurant.toString();
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
