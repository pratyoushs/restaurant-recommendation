package com.webapp.rr.repo;

import com.webapp.rr.domain.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.annotation.QueryResult;
import org.springframework.data.neo4j.repository.GraphRepository;

import java.util.List;

public interface UserRepository extends GraphRepository<User> {

    User findByFirstName(String firstName);

    @Query("match (u:User{firstName:{0}})-[f:Friend_Of]->(u2:User) return u2")
    List<User> getFriends(String firstName);



}