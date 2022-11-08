package com.hcmut.learningsystemserverrest.controller;

import com.hcmut.learningsystemserverrest.service.EmployeeService;
import com.hcmut.learningsystemserverrest.service.dto.EmployeeInfoDTO;
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
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public ResponseEntity<CustomResponse> getAllEmployee() {
        List<EmployeeInfoDTO> employees = employeeService.getAllEmployee();

        Map<String, Object> data = new HashMap<>();
        data.put("employees", employees);
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
