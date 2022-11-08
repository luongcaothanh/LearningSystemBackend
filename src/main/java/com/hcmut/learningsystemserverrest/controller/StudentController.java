package com.hcmut.learningsystemserverrest.controller;

import com.hcmut.learningsystemserverrest.service.StudentService;
import com.hcmut.learningsystemserverrest.service.dto.StudentInfoDTO;
import com.hcmut.learningsystemserverrest.service.response.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public ResponseEntity<CustomResponse> getAllStudent() {
        List<StudentInfoDTO> students = studentService.getAllStudent();

        Map<String, Object> data = new HashMap<>();
        data.put("students", students);
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
