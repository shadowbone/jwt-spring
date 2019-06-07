package com.bone.bone.controllers;

import com.bone.bone.common.DocoHelpers;
import com.bone.bone.models.User;
import com.bone.bone.payload.SignUpRequest;
import com.bone.bone.repository.UserRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public JsonNode registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            Map body = new HashMap<>();
            body.put("username","Username sudah di pakai.");
            return DocoHelpers.response(body, 400);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            Map body = new HashMap<>();
            body.put("email","Email sudah di pakai.");
            return DocoHelpers.response(body, 400);
        }

        User user = new User(signUpRequest.getName() ,signUpRequest.getUsername(), signUpRequest.getEmail(),signUpRequest.getPassword());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User result = userRepository.save(user);

        Map body = new HashMap<>();
        body.put("messages","User berhasil tersimpan " + result.getName());
        return  DocoHelpers.response(body,201);
    }
}
