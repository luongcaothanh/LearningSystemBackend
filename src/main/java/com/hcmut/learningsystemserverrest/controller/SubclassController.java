package com.hcmut.learningsystemserverrest.controller;

import com.hcmut.learningsystemserverrest.service.SubclassService;
import com.hcmut.learningsystemserverrest.service.dto.SubclassCreatedDTO;
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
public class SubclassController {
    @Autowired
    private SubclassService subclassService;

    @PostMapping("/create/subclass")
    public ResponseEntity<CustomResponse> createSubclass(@ModelAttribute SubclassCreatedDTO subclassCreatedDTO) {
        subclassService.createSubclass(subclassCreatedDTO.getId(), subclassCreatedDTO.getCsemester(),
                                        subclassCreatedDTO.getcYear(), subclassCreatedDTO.getcType(),
                                        subclassCreatedDTO.getCsubjectID(), subclassCreatedDTO.getLecturerID());

        Map<String, Object> data = new HashMap<>();
        data.put("id", subclassCreatedDTO.getId());
        data.put("semester", subclassCreatedDTO.getCsemester());
        data.put("year", subclassCreatedDTO.getcYear());
        data.put("type", subclassCreatedDTO.getcType());
        data.put("subjectID", subclassCreatedDTO.getCsubjectID());
        data.put("lecturerID", subclassCreatedDTO.getLecturerID());
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
