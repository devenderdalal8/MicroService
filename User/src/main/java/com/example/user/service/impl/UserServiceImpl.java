package com.example.user.service.impl;

import com.example.user.entity.Hotel;
import com.example.user.entity.Rating;
import com.example.user.entity.User;
import com.example.user.exception.ResourceNotFoundException;
import com.example.user.repository.UserRepository;
import com.example.user.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User create(User user) {
        user.setId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    public User getUser(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with user Id: " + id));
        //http://localhost:8083/api/rating/user/6cdf3efb-d832-4501-8e01-b442275cdf05
        /*We have dynamic service registry so to use that we will choose the Application name
         * from eureka services.to using this we have to  replace the base url
         * with Eureka service registry Application name e.g  'http://RATING'*/
        Rating[] ratingList = restTemplate.getForObject("http://RATING-SERVICE/api/rating/user/{userId}", Rating[].class, id);
        List<Rating> ratings = Arrays.stream(ratingList).toList();
        logger.info("User rating list: {}", ratingList);
        List<Rating> updatedRating = ratings.stream().map(rating -> {
            Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/api/hotel/{id}", Hotel.class, rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        user.setRating(updatedRating);
        return user;
    }

    public User ratingHotelFallback(String id, Exception ex) {
        logger.info("Falling back to hotel fallback");
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with user Id: " + id));
    }
}
