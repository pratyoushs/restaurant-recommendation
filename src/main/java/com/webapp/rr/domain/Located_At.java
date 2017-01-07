package com.webapp.rr.domain;

import org.neo4j.ogm.annotation.*;

/**
 * Created by Pratyoush on 12/30/2016.
 */
@RelationshipEntity(type = "Located_At")
public class Located_At {
    @GraphId private Long id;
    @StartNode
    Restaurant restaurant;
    @EndNode
    Location location;

    public String toString(){
        return restaurant.toString() + " -located_at- " + location.toString();
    }
}

