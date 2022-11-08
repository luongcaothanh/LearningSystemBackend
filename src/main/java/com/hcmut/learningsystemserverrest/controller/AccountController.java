package com.hcmut.learningsystemserverrest.controller;

import com.hcmut.learningsystemserverrest.service.AccountService;
import com.hcmut.learningsystemserverrest.service.response.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private AccountService accountService;

    @PostMapping("/account/login")
    public ResponseEntity<CustomResponse> login(@RequestParam String username, @RequestParam String password) {
        String accessToken = accountService.login(username, password);

        Map<String, Object> data = new HashMap<>();
        data.put("accessToken", accessToken);
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
