package com.example.redditclonefinalproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "Comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    private String id;

    private String text;

    private Post post;

    private Instant createdDate;

    private User user;
}
