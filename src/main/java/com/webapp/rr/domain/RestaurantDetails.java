package com.webapp.rr.domain;

import org.springframework.data.neo4j.annotation.QueryResult;

/**
 * Created by Pratyoush on 12/30/2016.
 */
@QueryResult
public class RestaurantDetails {
    String restaurantName;
    String address;
    String phone;
    String cuisineType;
    String state;
    String pin;
    String rating;
    String restaurantId;

    public String toString(){
        return restaurantName + " " + address + " " + phone + " " + cuisineType
                + " " + state + " " + pin + " " + rating;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
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

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

}
