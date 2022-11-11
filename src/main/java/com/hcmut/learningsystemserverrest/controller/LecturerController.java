package com.hcmut.learningsystemserverrest.controller;

import com.hcmut.learningsystemserverrest.service.LecturerService;
import com.hcmut.learningsystemserverrest.service.dto.EmployeeCreatedDTO;
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
}
