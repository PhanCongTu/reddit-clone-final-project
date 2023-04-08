package com.example.redditclonefinalproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "Post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    private String postId;

    private String postName;

    private String url;

    private String description;

    private Integer voteCount = 0;

    private User user;

    private Instant createdDate;

    private Subreddit subreddit;
}
