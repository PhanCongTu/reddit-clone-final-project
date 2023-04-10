package com.example.redditclonefinalproject.controllers;

import com.example.redditclonefinalproject.dtos.AuthenticationResponse;
import com.example.redditclonefinalproject.dtos.LoginRequest;
import com.example.redditclonefinalproject.dtos.RegisterRequest;
import com.example.redditclonefinalproject.models.VerificationToken;
import com.example.redditclonefinalproject.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/Signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest){
        authService.signup(registerRequest);
        return new ResponseEntity<>("User registration successful", HttpStatus.OK);
    }

    @GetMapping("/accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token){
         authService.verifyAccount(token);
         return new ResponseEntity<>("Account activated successfully", HttpStatus.OK);
    }

}
