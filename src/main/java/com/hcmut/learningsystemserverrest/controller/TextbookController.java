package com.hcmut.learningsystemserverrest.controller;

import com.hcmut.learningsystemserverrest.service.TextbookService;
import com.hcmut.learningsystemserverrest.service.dto.TextbookCreatedDTO;
import com.hcmut.learningsystemserverrest.service.response.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TextbookController {
    @Autowired
    private TextbookService textbookService;

    @PostMapping("/create/textbook")
    public ResponseEntity<CustomResponse> createTextbook(@ModelAttribute TextbookCreatedDTO textbookCreatedDTO) {
        textbookService.createTextbook(textbookCreatedDTO.getId(), textbookCreatedDTO.getTextbookName(),
                                        textbookCreatedDTO.getPublishingHouse(), textbookCreatedDTO.getPublishingYear(),
                                        textbookCreatedDTO.getCategory(), textbookCreatedDTO.getAuthorName(),
                                        textbookCreatedDTO.getSubjectID());

        Map<String, Object> data = new HashMap<>();
        data.put("name", textbookCreatedDTO.getTextbookName());
        data.put("authorName", textbookCreatedDTO.getAuthorName());
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
