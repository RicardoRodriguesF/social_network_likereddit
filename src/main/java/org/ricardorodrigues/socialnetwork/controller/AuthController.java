package org.ricardorodrigues.socialnetwork.controller;

import lombok.AllArgsConstructor;
import org.ricardorodrigues.socialnetwork.dto.AuthenticationResponse;
import org.ricardorodrigues.socialnetwork.dto.LoginRequest;
import org.ricardorodrigues.socialnetwork.dto.RegisterRequest;
import org.ricardorodrigues.socialnetwork.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("server ok", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        return new ResponseEntity<>("User Registration Successfully", HttpStatus.OK);
    }

    @GetMapping("accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token){
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account activate", HttpStatus.OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest);

    }

}
