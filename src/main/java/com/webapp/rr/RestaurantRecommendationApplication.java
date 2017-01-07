package com.webapp.rr;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.webapp.rr.domain.User;
import com.webapp.rr.repo.CuisineRepository;
import com.webapp.rr.repo.LocationRepository;
import com.webapp.rr.repo.RestaurantRepository;
import com.webapp.rr.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableNeo4jRepositories
@SpringBootApplication
public class RestaurantRecommendationApplication {

	private final static Logger log = LoggerFactory.getLogger(RestaurantRecommendationApplication.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RestaurantRecommendationApplication.class, args);
	}

	@Bean
	CommandLineRunner demo(UserRepository userRepository, RestaurantRepository restaurantRepository, CuisineRepository cuisineRepository, LocationRepository locationRepository) {
		return args -> {

			List<User> friends = new LinkedList<User>();
			log.info("Restaurants are: " + restaurantRepository.getRestaurantDetails().toString());
			/*log.info("Friends are: " + userRepository.getFriends("Martin").toString());
			log.info("Restaurants liked are: " + userRepository.findByFirstName("Martin").likesRestaurants);
			log.info("Cuisines are: " + cuisineRepository.findByCuisineType("Mexican"));
			log.info("Locations are: " + locationRepository.findByState("TX"));
			log.info("Restaurants are: " + restaurantRepository.findByRestaurantName("Arby's"));
			log.info("Lookup each person by name...");
			log.info("\t" + userRepository.findAll().toString());*/
		};
	}

}