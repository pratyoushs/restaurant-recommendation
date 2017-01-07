package com.webapp.rr.repo;

import com.sun.prism.GraphicsResource;
import com.webapp.rr.domain.Cuisine;
import org.neo4j.ogm.annotation.GraphId;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by Pratyoush on 12/30/2016.
 */
public interface CuisineRepository extends GraphRepository<Cuisine> {
    Cuisine findByCuisineId(String cuisineId);
    Cuisine findByCuisineType(String cuisineType);
}
