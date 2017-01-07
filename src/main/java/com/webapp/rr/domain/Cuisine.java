package com.webapp.rr.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by Pratyoush on 12/30/2016.
 */
@NodeEntity
public class Cuisine {
    @GraphId private Long id;
    private String cuisineType;
    private String cuisineId;

    public Cuisine() {
    }

    public Cuisine(String cuisineName, String cuisineType, String cuisineId) {
        this.cuisineType = cuisineType;
        this.cuisineId = cuisineId;
    }

    public String toString(){
        return cuisineType;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(String cuisineId) {
        this.cuisineId = cuisineId;
    }
}
