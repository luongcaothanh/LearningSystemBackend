package com.hcmut.learningsystemserverrest.controller;

import com.hcmut.learningsystemserverrest.service.StudentService;
import com.hcmut.learningsystemserverrest.service.dto.AttendSubclassCreatedDTO;
import com.hcmut.learningsystemserverrest.service.dto.StudentCreatedDTO;
import com.hcmut.learningsystemserverrest.service.dto.StudentInfoDTO;
import com.hcmut.learningsystemserverrest.service.response.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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

    @GetMapping("/student/faculty")
    public ResponseEntity<CustomResponse> getStudentOfFaculty(@RequestParam String facultyName) {
        List<StudentInfoDTO> students = studentService.getStudentOfFaculty(facultyName);

        Map<String, Object> data = new HashMap<>();
        data.put("students", students);
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create/student")
    public ResponseEntity<CustomResponse> createStudent(@RequestBody StudentCreatedDTO studentCreatedDTO) {
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

    @PostMapping("/attend")
    public ResponseEntity<CustomResponse> attendSubclass(@RequestBody AttendSubclassCreatedDTO attendSubclassCreatedDTO,
                                                         Authentication authentication) {
        studentService.attendSubclass(attendSubclassCreatedDTO.getScid(),
                                        attendSubclassCreatedDTO.getScSemester(),
                                        attendSubclassCreatedDTO.getScYear(),
                                        attendSubclassCreatedDTO.getScType(),
                                        attendSubclassCreatedDTO.getScSubjectID(),
                                        authentication);

        Map<String, Object> data = new HashMap<>();
        data.put("subclassID", attendSubclassCreatedDTO.getScid());
        data.put("semester", attendSubclassCreatedDTO.getScSemester());
        data.put("year", attendSubclassCreatedDTO.getScYear());
        data.put("type", attendSubclassCreatedDTO.getScType());
        data.put("subjectID", attendSubclassCreatedDTO.getScSubjectID());
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/student/{personID}")
    public ResponseEntity<CustomResponse> getStudentInfo(@PathVariable String personID) {
        StudentInfoDTO student = studentService.getStudentInfo(personID);

        Map<String, Object> data = new HashMap<>();
        data.put("student", student);
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
