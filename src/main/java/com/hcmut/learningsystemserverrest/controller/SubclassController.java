package com.hcmut.learningsystemserverrest.controller;

import com.hcmut.learningsystemserverrest.service.SubclassService;
import com.hcmut.learningsystemserverrest.service.dto.*;
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

    @GetMapping("/subclass_class")
    public ResponseEntity<CustomResponse> getSBOfClassInSemester(@RequestParam String subjectID,
                                                                 @RequestParam String semester) {
        List<SubclassOfClassDTO> subclassOfClasses = subclassService.getSBOfClassInSemester(subjectID, semester);

        Map<String, Object> data = new HashMap<>();
        data.put("subclassOfClasses", subclassOfClasses);
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/subclass_student/{studentID}")
    public ResponseEntity<CustomResponse> getSubclassOfStudent(@PathVariable String studentID) {
        List<SubclassOfStudentDTO> subclassesOfStudent = subclassService.getSubclassOfStudent(studentID);

        Map<String, Object> data = new HashMap<>();
        data.put("subclassesOfStudent", subclassesOfStudent);
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/subclass_lecturer/{lecturerID}")
    public ResponseEntity<CustomResponse> getSubclassOfLecturer(@PathVariable String lecturerID) {
        List<SubclassOfLecturerDTO> subclassesOfLecturer = subclassService.getSubclassOfLecturer(lecturerID);

        Map<String, Object> data = new HashMap<>();
        data.put("subclassesOfLecturer", subclassesOfLecturer);
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/subclass/student")
    public ResponseEntity<CustomResponse> getStudentsOfSubclass(@RequestParam String subclassID,
                                                                @RequestParam String semester,
                                                                @RequestParam String subjectID) {
        List<StudentOfSubclassDTO> students = subclassService.getStudentsOfSubclass(subclassID, semester, subjectID);

        Map<String, Object> data = new HashMap<>();
        data.put("students", students);
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/subclass_subject/{subjectID}")
    public ResponseEntity<CustomResponse> getSubclassOfSubject(@PathVariable String subjectID) {
        List<SubclassOfSubjectDTO> subclassesOfSubject = subclassService.getSubclassOfSubject(subjectID);

        Map<String, Object> data = new HashMap<>();
        data.put("subclassesOfSubject", subclassesOfSubject);
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
