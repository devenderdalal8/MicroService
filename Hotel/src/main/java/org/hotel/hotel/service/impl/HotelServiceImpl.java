package org.hotel.hotel.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hotel.hotel.entity.Hotel;
import org.hotel.hotel.entity.RatingDto;
import org.hotel.hotel.external.service.RatingService;
import org.hotel.hotel.repository.HotelRepository;
import org.hotel.hotel.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RatingService ratingService;
    private static final Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);

    @Override
    public Hotel create(Hotel hotel) {
        Hotel hotel1 = new Hotel();
        hotel1.setId(UUID.randomUUID().toString());
        hotel1.setName(hotel.getName());
        hotel1.setLocation(hotel.getLocation());
        hotel1.setAbout(hotel.getAbout());
        return hotelRepository.save(hotel1);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel findById(String id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel not found"));
        //give rating service
        String ratingsString = ratingService.getRatingByHotelId(id);
        logger.info("ratings: {}", ratingsString);

        ObjectMapper mapper = new ObjectMapper();
        List<RatingDto> ratings = new ArrayList<>();
        try {
            ratings = mapper.readValue(ratingsString, new TypeReference<>(){});
        } catch (Exception e) {
            logger.error("Error parsing ratings", e);
        }

        hotel.setRatingDto(ratings);
        return hotel;
    }
}
