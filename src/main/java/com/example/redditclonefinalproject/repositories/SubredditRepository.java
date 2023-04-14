package com.example.redditclonefinalproject.repositories;

import com.example.redditclonefinalproject.models.Subreddit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubredditRepository extends MongoRepository<Subreddit, String> {

    Optional<Subreddit> findByName(String subredditName);
}
