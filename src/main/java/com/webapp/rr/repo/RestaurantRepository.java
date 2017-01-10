package com.webapp.rr.repo;

import com.webapp.rr.domain.Restaurant;
import com.webapp.rr.domain.RestaurantDetails;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Pratyoush on 12/30/2016.
 */
public interface RestaurantRepository extends GraphRepository<Restaurant> {
    Restaurant findByRestaurantName(String restaurantName);
    Restaurant findByRestaurantId(String restaurantId);

    //Creates serves relationship between restaurant and cuisine
    @Query("MATCH (r:Restaurant), (c:Cuisine) " +
            "WHERE r.cuisineId = {0} AND c.cuisineId = {0}" +
            "CREATE (r)-[s:Serves]->(c)")
    void createServes(String cuisineId);

    //Creates located_at relationship between restaurant and location
    @Query("MATCH (r:Restaurant), (c:Location) " +
            "WHERE r.locationId = {0} AND c.locationId = {0}" +
            "CREATE (r)-[s:Located_At]->(c)")
    void createLocatedAt(String locationId);
/*
    //Returns restaurant and it's average rating given by the user
    @Query("MATCH (p:User)-[l:Likes]->(r:Restaurant) RETURN r, avg(l.Rating)")
    List<AverageRating> getAverageRating();*/

    //Returns all the restaurants with its details, cuisine served and location located_at.
    @Query("MATCH (r)-[s:Serves]->(c:Cuisine), (r)-[loc:Located_At]->(location:Location) " +
            " RETURN DISTINCT r.restaurantName as restaurantName, r.address as address, r.phone as phone, " +
            "c.cuisineType as cuisineType, location.state as state, location.pin as pin, r.rating as rating, " +
            "r.restaurantId as restaurantId limit 100")
    List<RestaurantDetails> getRestaurantDetails();

    @Query("MATCH (r)-[s:Serves]->(c:Cuisine), (r)-[loc:Located_At]->(location:Location) " +
            "WHERE r.restaurantName =~{0} AND c.cuisineType =~{1} AND location.state =~ {2} AND r.rating =~ {3} " +
            " RETURN DISTINCT r.restaurantName as restaurantName, r.address as address, r.phone as phone, " +
            "c.cuisineType as cuisineType, location.state as state, location.pin as pin, r.rating as rating, " +
            "r.restaurantId as restaurantId limit 100")
    List<RestaurantDetails> getRestaurantDetails(String restaurantName, String cuisineType, String state, String rating);

    //Returns retaurant nodes along with average ratings, cuisine nodes and location nodes
    @Query("MATCH (r:Restaurant{restaurantId: {0}})-[s:Serves]->(c:Cuisine), (r)-[loc:Located_At]->(location:Location) " +
                   "  RETURN r.restaurantName as restaurantName, r.address as address, r.phone as phone, " +
            "c.cuisineType as cuisineType, location.state as state, location.pin as pin, r.rating as rating, " +
            "r.restaurantId as restaurantId")
    List<RestaurantDetails> getRestaurantInfo(String restaurantId);

    //restaurants liked by friends
    @Query("MATCH (u:User)-[:Friend_Of]->(friend), (friend)-[:Likes]->(r:Restaurant), " +
            "(r)-[:Located_At]->(location:Location), (r)-[:Serves]->(c:Cuisine) WHERE u.userId={0}" +
            "RETURN r.restaurantName as restaurantName, r.address as address, r.phone as phone, " +
            "c.cuisineType as cuisineType, location.state as state, location.pin as pin, r.rating as rating, " +
            "r.restaurantId as restaurantId ORDER BY r.rating DESC " +
            "LIMIT 10")
    List<RestaurantDetails> getFriendRecommendedRestaurants(String userId);

    @Query("MATCH (u:User)-[:Friend_Of]->(friend), (friend)-[:Likes]->(r:Restaurant), " +
            "(r)-[:Located_At]->(location:Location), (r)-[:Serves]->(c:Cuisine) " +
            "WHERE u.userId = {0} AND r.restaurantName =~ {1} AND c.cuisineType =~{2} AND location.state =~ {3} AND r.rating =~ {4} " +
            "RETURN r.restaurantName as restaurantName, r.address as address, r.phone as phone, " +
            "c.cuisineType as cuisineType, location.state as state, location.pin as pin, r.rating as rating, " +
            "r.restaurantId as restaurantId ORDER BY r.rating DESC " +
            "LIMIT 10")
    List<RestaurantDetails> getFriendRecommendedRestaurants(String userId, String restaurantName, String cuisine, String state, String rating);

    //restaurant recommendations based on your likes
    @Query("MATCH (u:User)-[l:Likes]->(r:Restaurant) WITH u, collect(r.restaurantId) as rid " +
            "MATCH (u:User)-[l:Likes]->(r:Restaurant),(r)-[s:Serves]->(c:Cuisine)<-[:Serves]-(r2:Restaurant), " +
            "(r)-[:Located_At]->(location) WHERE r2.rating >= \"3\" AND l.rating >= \"3\" AND r.locationId = r2.locationId " +
            "AND u.userId = {0} AND NOT(r2.restaurantId IN rid) WITH r,r2,c,location,rid " +
            "RETURN DISTINCT r2.restaurantName as restaurantName, r2.address as address, r2.phone as phone, " +
            "c.cuisineType as cuisineType, location.state as state, location.pin as pin, r2.rating as rating, " +
            "r2.restaurantId as restaurantId ORDER BY r2.rating DESC\n" +
            "LIMIT 10")
    List<RestaurantDetails> getRestaurantRecommendations(String userId);

    @Query("MATCH (u:User)-[l:Likes]->(r:Restaurant) WITH u, collect(r.restaurantId) as rid " +
            "MATCH (u:User)-[l:Likes]->(r:Restaurant),(r)-[s:Serves]->(c:Cuisine)<-[:Serves]-(r2:Restaurant), " +
            "(r)-[:Located_At]->(location) WHERE r2.rating >= \"3\" AND l.rating >= \"3\" AND r.locationId = r2.locationId " +
            "AND r2.restaurantName =~ {1} AND c.cuisineType =~{2} AND location.state =~ {3} AND r2.rating =~ {4} " +
            "AND u.userId = {0} AND NOT(r2.restaurantId IN rid) WITH r,r2,c,location,rid " +
            "RETURN DISTINCT r2.restaurantName as restaurantName, r2.address as address, r2.phone as phone, " +
            "c.cuisineType as cuisineType, location.state as state, location.pin as pin, r2.rating as rating, " +
            "r2.restaurantId as restaurantId ORDER BY r2.rating DESC\n" +
            "LIMIT 10")
    List<RestaurantDetails> getRestaurantRecommendations(String userId, String restaurantName, String cuisine, String state, String rating);

    //Merges/Creates a rating given by a user to restaurant
    @Query ("MATCH (u:User{userId:{0}}),(r:Restaurant{restaurantId:{1}}) " +
            "MERGE (u)-[l:Likes]->(r) " +
            "ON CREATE SET l.rating = {2} " +
            "ON MATCH SET l.rating = {2} ")
    void giveRating(String userId, String restaurantId, String rating);
}
