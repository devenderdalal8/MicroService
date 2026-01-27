package org.database.ratingservice.service;

import org.database.ratingservice.enitity.Rating;

import java.util.List;

public interface RatingService {

    //create
    Rating create(Rating rating);

    //get all
    List<Rating> findAll();

    // get by id
    Rating findById(String id);

    // get rating by user id
    List<Rating> findByUserId(String userId);

    // get rating by hotel id
    List<Rating> findByHotelId(String hotelId);
}
