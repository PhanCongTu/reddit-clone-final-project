package com.example.redditclonefinalproject.models;

import com.example.redditclonefinalproject.utils.VoteType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Vote")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vote {
    private Long voteId;

    private VoteType voteType;

    private Post post;

    private User user;
}
