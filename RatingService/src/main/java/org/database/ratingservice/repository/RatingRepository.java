package org.database.ratingservice.repository;

import org.database.ratingservice.enitity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, String>{
    List<Rating> findByUserId(String userId);

    List<Rating> findByHotelId(String hotelId);
}
