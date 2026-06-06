package com.nourishhub.auth_service.controller;

import com.nourishhub.auth_service.dto.RegisterRequest;
import com.nourishhub.auth_service.entity.User;
import com.nourishhub.auth_service.repository.UserRepository;
import com.nourishhub.auth_service.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.nourishhub.auth_service.dto.LoginRequest;
import java.util.Optional;
import com.nourishhub.auth_service.entity.Role;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;

    @GetMapping("/hello")
    public String hello() {
        return "NourishHub Auth Service Running 🚀";
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setRole(Role.USER);
        userRepository.save(user);

        return "User Registered Successfully!";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        Optional<User> optionalUser =
                userRepository.findByUsername(request.getUsername());

        if (optionalUser.isEmpty()) {
            return "User not found!";
        }

        User user = optionalUser.get();

        boolean passwordMatches =
                passwordEncoder.matches(
                        request.getPassword(),
                        user.getPassword()
                );

        if (!passwordMatches) {
            return "Invalid Password!";
        }

        String token =
                jwtService.generateToken(
                        user.getUsername(),
                        user.getRole().name()
                );

        return token;
    }

    @GetMapping("/profile")
    public String profile() {

        return "Protected Profile API 🔐";
    }

    @GetMapping("/admin")
    public String adminAccess() {

        return "Welcome Admin 👑";
    }
}