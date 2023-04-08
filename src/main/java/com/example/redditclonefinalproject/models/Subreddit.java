package com.example.redditclonefinalproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document(collection = "Subreddit")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subreddit {

    @Id
    private String id;

    private String name;

    private String description;

    private List<Post> posts;

    private Instant createdDate;

    private User user;
}
