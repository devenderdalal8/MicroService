package org.hotel.hotel.controller;

import lombok.extern.slf4j.Slf4j;
import org.hotel.hotel.entity.Hotel;
import org.hotel.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    //create
    @PostMapping
    public ResponseEntity<Hotel> create(@RequestBody Hotel hotel) {
        log.debug("Creating Hotel with name {}", hotel.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    //get all
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAllHotel());
    }

    //find by id
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotels(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.findById(id));
    }
}
