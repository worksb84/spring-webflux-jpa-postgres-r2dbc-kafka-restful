package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.annotation.ErrorLog;
import com.example.demo.domain.User;
import com.example.demo.helper.JwtTokenProvider;
import com.example.demo.service.UserQueryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthQueryController {

    @Autowired
    private UserQueryService userQueryService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @ErrorLog
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<String> create(@RequestBody User user) {

        try {
            UserDetails u = userQueryService.auth(user);

            if (!passwordEncoder.matches(user.getPassword(), user.getPassword())) {
                throw new UsernameNotFoundException("Invalid credentials");
            }

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    u, null, u.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtTokenProvider.generateToken(authentication);
            return ResponseEntity.ok(jwt);
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }

    }
}
