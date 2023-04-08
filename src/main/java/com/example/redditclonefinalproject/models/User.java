package com.example.redditclonefinalproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
@Document(collection = "User")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String userId;

    private String username;

    private String password;

    private String email;

    private Instant created;

    private boolean enabled;
}

