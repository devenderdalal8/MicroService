package org.database.ratingservice.service.impl;

import org.database.ratingservice.enitity.Rating;
import org.database.ratingservice.exception.ResourceNotFoundException;
import org.database.ratingservice.repository.RatingRepository;
import org.database.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    RatingRepository repository;

    @Override
    public Rating create(Rating rating) {
        rating.setId(UUID.randomUUID().toString());
        return repository.save(rating);
    }

    @Override
    public List<Rating> findAll() {
        return repository.findAll();
    }

    @Override
    public Rating findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rating not found by Id :" + id));
    }

    @Override
    public List<Rating> findByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<Rating> findByHotelId(String hotelId) {
        return repository.findByHotelId(hotelId);
    }
}
