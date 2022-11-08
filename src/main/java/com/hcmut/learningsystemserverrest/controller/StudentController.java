package com.hcmut.learningsystemserverrest.controller;

import com.hcmut.learningsystemserverrest.repository.StudentRepository;
import com.hcmut.learningsystemserverrest.service.dto.StudentInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/student")
    public List<StudentInfoDTO> getAllStudent() {
        return studentRepository.getAllStudent();
    }
}
