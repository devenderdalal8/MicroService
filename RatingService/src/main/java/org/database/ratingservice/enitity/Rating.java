package org.database.ratingservice.enitity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Entity
@Table(name = "Rating")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Rating {
    @Id
    private String id;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;

}
