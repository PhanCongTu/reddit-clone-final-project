package com.example.redditclonefinalproject.repositories;

import com.example.redditclonefinalproject.models.VerificationToken;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VerificationTokenRepository extends MongoRepository<VerificationToken, String> {
     Optional<VerificationToken> findByToken(String token);
}
