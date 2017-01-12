package com.webapp.rr.repo;

import com.webapp.rr.domain.User;
import com.webapp.rr.domain.UserDetails;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.annotation.QueryResult;
import org.springframework.data.neo4j.repository.GraphRepository;

import java.util.List;

public interface UserRepository extends GraphRepository<User> {

    @Query("MATCH (u:User)-[:Friend_Of]->(u2:User) WHERE (u.userId={0}) " +
            "RETURN u2.firstName as firstName, u2.lastName as lastName, u2.email as email, " +
            "u2.gender as gender, true as isFriend")
    List<UserDetails> getAllFriends(String userId);

    @Query("MATCH (u:User),(u2:User) WHERE NOT((u)-[:Friend_Of]->(u2)) AND u2.userId <> {0} AND u.userId={0} " +
            "RETURN u2.firstName as firstName, u2.lastName as lastName, u2.email as email, " +
            "u2.gender as gender, false as isFriend")
    List<UserDetails> getAllOtherUsers(String userId);

    @Query("MATCH (u:User),(u2:User) WHERE u.userId={0} AND u2.email={1} " +
            "MERGE (u)-[:Friend_Of]->(u2)")
    void addFriend(String userId, String email);

    @Query("MATCH (u:User)-[f:Friend_Of]->(u2:User) WHERE u.userId={0} AND u2.email={1} " +
            "DELETE f")
    void deleteFriend(String userId, String email);

    @Query("MATCH (u:User) RETURN u.username as username, u.password as password")
    List<UserDetails> getUserCredentials();

    @Query("MATCH (u:User) WITH COLLECT (u) AS userNodes RETURN toString(size(userNodes)+1)")
    String getUserId();

}