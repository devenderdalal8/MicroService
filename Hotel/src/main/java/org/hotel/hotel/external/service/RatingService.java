package org.hotel.hotel.external.service;

import org.hotel.hotel.entity.RatingDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
    @GetMapping(value = "/api/rating/hotel/{hotelId}")
    String getRatingByHotelId(@PathVariable("hotelId") String hotelId);
}