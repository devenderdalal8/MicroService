package com.example.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "Users")
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    @Transient
    private List<Rating> rating = new ArrayList<>();
}
