package com.hcmut.learningsystemserverrest.controller;

import com.hcmut.learningsystemserverrest.service.StudentService;
import com.hcmut.learningsystemserverrest.service.dto.StudentCreatedDTO;
import com.hcmut.learningsystemserverrest.service.dto.StudentInfoDTO;
import com.hcmut.learningsystemserverrest.service.response.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create/student")
    public ResponseEntity<CustomResponse> createStudent(@ModelAttribute StudentCreatedDTO studentCreatedDTO) {
        StudentCreatedDTO studentCreatedDTO1 = studentService.createStudent(studentCreatedDTO.getIdCard(),
                studentCreatedDTO.getGender(),
                studentCreatedDTO.getfName(),
                studentCreatedDTO.getlName(),
                studentCreatedDTO.getDoB(),
                studentCreatedDTO.getEmail(),
                studentCreatedDTO.getStudentID(),
                studentCreatedDTO.getAdmissionYear(),
                studentCreatedDTO.getFacultyName(),
                studentCreatedDTO.getUsername(),
                studentCreatedDTO.getPassword());

        Map<String, Object> data = new HashMap<>();
        data.put("username", studentCreatedDTO.getUsername());
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
