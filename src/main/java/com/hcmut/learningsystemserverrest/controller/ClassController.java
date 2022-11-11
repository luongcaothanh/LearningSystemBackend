package com.hcmut.learningsystemserverrest.controller;

import com.hcmut.learningsystemserverrest.service.ClassService;
import com.hcmut.learningsystemserverrest.service.dto.ClassCreatedDTO;
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
public class ClassController {
    @Autowired
    private ClassService classService;

    @PostMapping("/create/class")
    public ResponseEntity<CustomResponse> createClass(@ModelAttribute ClassCreatedDTO classCreatedDTO) {
        classService.createClass(classCreatedDTO.getSemester(), classCreatedDTO.getClassYear(),
                                classCreatedDTO.getClassType(), classCreatedDTO.getSubjectID());

        Map<String, Object> data = new HashMap<>();
        data.put("semester", classCreatedDTO.getSemester());
        data.put("year", classCreatedDTO.getClassYear());
        data.put("type", classCreatedDTO.getClassType());
        data.put("subjectID", classCreatedDTO.getSubjectID());
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
