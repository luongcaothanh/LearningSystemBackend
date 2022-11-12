package com.hcmut.learningsystemserverrest.controller;

import com.hcmut.learningsystemserverrest.service.PersonPhoneService;
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
public class PersonPhoneController {
    @Autowired
    private PersonPhoneService personPhoneService;

    @PostMapping("/phone")
    public ResponseEntity<CustomResponse> createPersonPhone(@RequestParam String personID,
                                                           @RequestParam String phoneNumber) {
        personPhoneService.createPersonPhone(personID, phoneNumber);

        Map<String, Object> data = new HashMap<>();
        data.put("personID", personID);
        data.put("phoneNumber", phoneNumber);
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
