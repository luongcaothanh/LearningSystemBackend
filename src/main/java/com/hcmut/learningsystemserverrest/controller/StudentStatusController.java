package com.hcmut.learningsystemserverrest.controller;

import com.hcmut.learningsystemserverrest.service.StudentStatusService;
import com.hcmut.learningsystemserverrest.service.dto.StudentStatusCreatedDTO;
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
public class StudentStatusController {
    @Autowired
    private StudentStatusService studentStatusService;

    @PostMapping("/create/student_status")
    public ResponseEntity<CustomResponse> createStudentStatus(@ModelAttribute StudentStatusCreatedDTO studentStatusCreatedDTO) {
        studentStatusService.createStudentStatus(studentStatusCreatedDTO.getStudentID(),
                studentStatusCreatedDTO.getSemester(),
                studentStatusCreatedDTO.getLearningStatus());

        Map<String, Object> data = new HashMap<>();
        data.put("studentID", studentStatusCreatedDTO.getStudentID());
        data.put("semester", studentStatusCreatedDTO.getSemester());
        data.put("learningStatus", studentStatusCreatedDTO.getLearningStatus());
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
