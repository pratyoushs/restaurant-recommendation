package com.webapp.rr.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import java.beans.Customizer;

/**
 * Created by Pratyoush on 12/30/2016.
 */
@RelationshipEntity(type = "Serves")
public class Serves {
    @GraphId private Long id;
    @StartNode
    Restaurant restaurant;
    @EndNode
    Cuisine cuisine;

    public String toString(){
        return restaurant.toString() + " -Serves- " + cuisine.toString();
    }
}
