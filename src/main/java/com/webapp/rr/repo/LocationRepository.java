package com.webapp.rr.repo;

import com.webapp.rr.domain.Location;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by Pratyoush on 12/30/2016.
 */
public interface LocationRepository extends GraphRepository<Location>{
    Location findByState(String state);
    Location findByCity(String city);
    Location findByPin(String pin);
}
