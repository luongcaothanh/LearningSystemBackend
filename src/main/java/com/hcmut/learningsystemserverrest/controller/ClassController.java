package com.hcmut.learningsystemserverrest.controller;

import com.hcmut.learningsystemserverrest.service.ClassService;
import com.hcmut.learningsystemserverrest.service.dto.ClassCreatedDTO;
import com.hcmut.learningsystemserverrest.service.dto.ClassDTO;
import com.hcmut.learningsystemserverrest.service.dto.ClassOfSubjectDTO;
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

    @GetMapping("/class/subject")
    public ResponseEntity<CustomResponse> getClassOfSubjectInSemester(@RequestParam String subjectID) {
        List<ClassOfSubjectDTO> classes = classService.getClassOfSubjectInSemester(subjectID);

        Map<String, Object> data = new HashMap<>();
        data.put("classes", classes);
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/class/faculty")
    public ResponseEntity<CustomResponse> getClassOfSubjectInSemesterOfFaculty(@RequestParam String semester,
                                                                      @RequestParam String facultyName) {
        List<ClassDTO> classes = classService.getClassOfSubjectInSemesterOfFaculty(semester, facultyName);

        Map<String, Object> data = new HashMap<>();
        data.put("classes", classes);
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
