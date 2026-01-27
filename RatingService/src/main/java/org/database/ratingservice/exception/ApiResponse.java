package org.database.ratingservice.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ApiResponse {
    String message;
    boolean success;
    HttpStatus status;
}
