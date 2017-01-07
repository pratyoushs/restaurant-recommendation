package com.webapp.rr.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by Pratyoush on 12/30/2016.
 */
@NodeEntity
public class Location {
    @GraphId private Long id;
    private String city;
    private String state;
    private String pin;
    private String locationId;

    public Location() {
    }

    public Location(String city, String state, String pin, String locationId) {
        this.city = city;
        this.state = state;
        this.pin = pin;
        this.locationId = locationId;
    }

    public String toString(){
        return pin;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }
}
