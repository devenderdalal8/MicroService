package org.hotel.hotel.service;

import org.hotel.hotel.entity.Hotel;

import java.util.List;

public interface HotelService {
    // create Hotel
    Hotel create(Hotel hotel);
    // get All
    List<Hotel> getAllHotel();

    // get by id
    Hotel findById(String id);
}
