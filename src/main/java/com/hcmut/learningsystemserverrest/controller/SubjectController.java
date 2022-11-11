package com.hcmut.learningsystemserverrest.controller;

import com.hcmut.learningsystemserverrest.service.SubjectService;
import com.hcmut.learningsystemserverrest.service.dto.SubjectCreatedDTO;
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
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @PostMapping("/create/subject")
    public ResponseEntity<CustomResponse> createSubject(@ModelAttribute SubjectCreatedDTO subjectCreatedDTO) {
        subjectService.createSubject(subjectCreatedDTO.getId(), subjectCreatedDTO.getSubjectName(),
                                        subjectCreatedDTO.getCreditsNo(), subjectCreatedDTO.getSubjectStatus(),
                                        subjectCreatedDTO.getFacultyName(), subjectCreatedDTO.getLecturerID());

        Map<String, Object> data = new HashMap<>();
        data.put("id", subjectCreatedDTO.getId());
        data.put("name", subjectCreatedDTO.getSubjectName());
        data.put("creditsNo", subjectCreatedDTO.getCreditsNo());
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
