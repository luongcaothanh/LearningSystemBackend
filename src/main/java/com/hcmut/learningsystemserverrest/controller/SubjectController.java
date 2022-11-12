package com.hcmut.learningsystemserverrest.controller;

import com.hcmut.learningsystemserverrest.service.SubjectService;
import com.hcmut.learningsystemserverrest.service.dto.PrerequisiteCreatedDTO;
import com.hcmut.learningsystemserverrest.service.dto.SubjectCreatedDTO;
import com.hcmut.learningsystemserverrest.service.dto.SubjectDTO;
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
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @PostMapping("/create/subject")
    public ResponseEntity<CustomResponse> createSubject(@ModelAttribute SubjectCreatedDTO subjectCreatedDTO) {
        subjectService.createSubject(subjectCreatedDTO.getId(), subjectCreatedDTO.getSubjectName(),
                                        subjectCreatedDTO.getCreditsNo(), subjectCreatedDTO.getSubjectStatus(),
                                        subjectCreatedDTO.getFacultyName(), subjectCreatedDTO.getLecturerID());

        Map<String, Object> data = new HashMap<>();
        data.put("id", subjectCreatedDTO.getId());
        data.put("name", subjectCreatedDTO.getSubjectName());
        data.put("creditsNo", subjectCreatedDTO.getCreditsNo());
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create/prerequisite")
    public ResponseEntity<CustomResponse> createPrerequisite(@ModelAttribute PrerequisiteCreatedDTO prerequisiteCreatedDTO) {
        subjectService.createPrerequisite(prerequisiteCreatedDTO.getSubjectID(),
                                            prerequisiteCreatedDTO.getPreSubjectID());

        Map<String, Object> data = new HashMap<>();
        data.put("subjectID", prerequisiteCreatedDTO.getSubjectID());
        data.put("preSubjectID", prerequisiteCreatedDTO.getPreSubjectID());
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/subject")
    public ResponseEntity<CustomResponse> getAllSubject() {
        List<SubjectDTO> subjects = subjectService.getAllSubject();

        Map<String, Object> data = new HashMap<>();
        data.put("subjects", subjects);
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/subject/faculty")
    public ResponseEntity<CustomResponse> getSubjectOfFaculty(@RequestParam String facultyName) {
        List<SubjectDTO> subjects = subjectService.getSubjectOfFaculty(facultyName);

        Map<String, Object> data = new HashMap<>();
        data.put("subjects", subjects);
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/subject/status")
    public ResponseEntity<CustomResponse> updateSubjectStatus(@RequestParam String subjectID) {
        subjectService.updateSubjectStatus(subjectID);

        Map<String, Object> data = new HashMap<>();
        data.put("subjectID", subjectID);
        CustomResponse response = new CustomResponse("Success", 0, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
