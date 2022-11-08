package com.hcmut.learningsystemserverrest.controller;

import com.hcmut.learningsystemserverrest.domain.Account;
import com.hcmut.learningsystemserverrest.service.response.CustomResponse;
import com.hcmut.learningsystemserverrest.service.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/account/login")
    public ResponseEntity<CustomResponse> login(@RequestParam String username, @RequestParam String password) {
        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));

            Account account = (Account) authenticate.getPrincipal();

            String accessToken = jwtTokenUtil.generateAccessToken(account);

            Map<String, Object> data = new HashMap<>();
            data.put("accessToken", accessToken);

            CustomResponse response = new CustomResponse("Success", 0, data);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (BadCredentialsException ex) {
            CustomResponse response = new CustomResponse("Invalid username or password", 401, null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}
