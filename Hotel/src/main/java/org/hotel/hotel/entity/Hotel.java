package org.hotel.hotel.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Hotel")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    @Id
    @Column(name = "id")
    String id;
    @Column(name = "name")
    String name;
    @Column(name = "location")
    String location;
    @Column(name = "about")
    String about;
    @Transient
    List<RatingDto> ratingDto = new ArrayList<>();
}
