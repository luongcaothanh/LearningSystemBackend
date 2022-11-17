package com.hcmut.learningsystemserverrest.controller;

import com.hcmut.learningsystemserverrest.service.LecturerService;
import com.hcmut.learningsystemserverrest.service.dto.EmployeeCreatedDTO;
import com.hcmut.learningsystemserverrest.service.dto.EmployeeInfoDTO;
import com.hcmut.learningsystemserverrest.service.dto.LecturerInfoDTO;
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
public class LecturerController {
    @Autowired
    private LecturerService lecturerService;

    @PostMapping("/create/lecturer")
    public ResponseEntity<CustomResponse> createManager(@ModelAttribute EmployeeCreatedDTO employeeCreatedDTO) {
        EmployeeCreatedDTO employeeInfoDTO = lecturerService.createLecturer(employeeCreatedDTO.getIdCard(),
                employeeCreatedDTO.getGender(),
                employeeCreatedDTO.getfName(),
                employeeCreatedDTO.getlName(),
                employeeCreatedDTO.getDoB(),
                employeeCreatedDTO.getEmail(),
                employeeCreatedDTO.getEmployeeID(),
                employeeCreatedDTO.getFacultyName(),
                employeeCreatedDTO.getUsername(),
                employeeCreatedDTO.getPassword());

        Map<String, Object> data = new HashMap<>();
        data.put("username", employeeCreatedDTO.getUsername());
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/lecturer")
    public ResponseEntity<CustomResponse> getAllLecturer() {
        List<LecturerInfoDTO> lecturers = lecturerService.getAllLecturer();

        Map<String, Object> data = new HashMap<>();
        data.put("lecturers", lecturers);
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/lecturer/faculty")
    public ResponseEntity<CustomResponse> getLecturerOfFaculty(@RequestParam String facultyName) {
        List<LecturerInfoDTO> lecturers = lecturerService.getLecturerOfFaculty(facultyName);

        Map<String, Object> data = new HashMap<>();
        data.put("lecturers", lecturers);
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/lecturer/{personID}")
    public ResponseEntity<CustomResponse> getLecturerInfo(@PathVariable String personID) {
        LecturerInfoDTO lecturer = lecturerService.getLecturerInfo(personID);

        Map<String, Object> data = new HashMap<>();
        data.put("lecturer", lecturer);
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
