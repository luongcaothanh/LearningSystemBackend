package com.hcmut.learningsystemserverrest.controller;

import com.hcmut.learningsystemserverrest.domain.Faculty;
import com.hcmut.learningsystemserverrest.service.FacultyService;
import com.hcmut.learningsystemserverrest.service.response.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping("/faculty")
    public ResponseEntity<CustomResponse> getAllFaculty() {
        List<Faculty> faculties = facultyService.getAllFaculty();

        Map<String, Object> data = new HashMap<>();
        data.put("faculties", faculties);
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create/faculty")
    public ResponseEntity<CustomResponse> createFaculty(@RequestParam String facultyName) {
        Faculty faculty = facultyService.createFaculty(facultyName);

        Map<String, Object> data = new HashMap<>();
        data.put("facultyName", facultyName);
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
