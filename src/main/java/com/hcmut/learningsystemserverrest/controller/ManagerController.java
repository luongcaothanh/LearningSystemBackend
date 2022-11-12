package com.hcmut.learningsystemserverrest.controller;

import com.hcmut.learningsystemserverrest.service.ManagerService;
import com.hcmut.learningsystemserverrest.service.dto.EmployeeCreatedDTO;
import com.hcmut.learningsystemserverrest.service.dto.EmployeeInfoDTO;
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
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @PostMapping("/create/manager")
    public ResponseEntity<CustomResponse> createManager(@ModelAttribute EmployeeCreatedDTO employeeCreatedDTO) {
        EmployeeCreatedDTO employeeInfoDTO = managerService.createManager(employeeCreatedDTO.getIdCard(),
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

    @GetMapping("/manager")
    public ResponseEntity<CustomResponse> getAllManager() {
        List<EmployeeInfoDTO> managers = managerService.getAllManager();

        Map<String, Object> data = new HashMap<>();
        data.put("managers", managers);
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
