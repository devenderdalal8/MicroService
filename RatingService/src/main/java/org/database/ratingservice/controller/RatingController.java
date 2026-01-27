package org.database.ratingservice.controller;

import org.database.ratingservice.enitity.Rating;
import org.database.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rating")
public class RatingController {

    @Autowired
    RatingService service;

    //create rating
    @PostMapping
    ResponseEntity<Rating> create(@RequestBody Rating rating) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(rating));
    }

    // get all rating
    @GetMapping
    ResponseEntity<List<Rating>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }


    // get all rating by user id;
    @GetMapping(value = "/user/{userId}" , consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    ResponseEntity<List<Rating>> findByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(service.findByUserId(userId));
    }

    // get all rating by hotel id;
    @GetMapping("/hotel/{hotelId}")
    ResponseEntity<List<Rating>> findByHotelId(@PathVariable String hotelId) {
        return ResponseEntity.ok(service.findByHotelId(hotelId));
    }

}
