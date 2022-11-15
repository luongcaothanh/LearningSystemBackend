package com.hcmut.learningsystemserverrest.controller;

import com.hcmut.learningsystemserverrest.domain.Account;
import com.hcmut.learningsystemserverrest.service.AccountService;
import com.hcmut.learningsystemserverrest.service.response.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/account/login")
    public ResponseEntity<CustomResponse> login(@RequestParam String username, @RequestParam String password,
                                                Authentication authentication) {
        String[] result = accountService.login(username, password);

        Map<String, Object> data = new HashMap<>();
        data.put("accessToken", result[0]);
        data.put("role", result[1]);
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/account/myinfo")
    public ResponseEntity<CustomResponse> getCurrentPerson(Authentication authentication) {
        Object object = accountService.getCurrentPerson(authentication);

        Map<String, Object> data = new HashMap<>();
        data.put("info", object);
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
