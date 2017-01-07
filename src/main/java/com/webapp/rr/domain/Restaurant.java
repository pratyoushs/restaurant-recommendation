package com.webapp.rr.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pratyoush on 12/30/2016.
 */
@NodeEntity
public class Restaurant {
    @GraphId private Long id;
    private String restaurantName;
    private String restaurantId;
    private String address;
    private String phone;
    private String locationId;
    private String cuisineId;
    private String rating;

    public Restaurant(){
    }

    public Restaurant(String restaurantName, String restaurantId, String address, String phone, String locationId, String cuisineId, String rating) {
        this.restaurantName = restaurantName;
        this.restaurantId = restaurantId;
        this.address = address;
        this.phone = phone;
        this.locationId = locationId;
        this.cuisineId = cuisineId;
        this.rating = rating;
    }

    @Relationship(type="Likes", direction = Relationship.INCOMING)
    public Set<Likes> likedBy;

    public String toString(){
        return this.restaurantName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(String cuisineId) {
        this.cuisineId = cuisineId;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
