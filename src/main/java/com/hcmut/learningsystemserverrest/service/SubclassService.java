package com.hcmut.learningsystemserverrest.service;

import com.hcmut.learningsystemserverrest.controller.customException.exception.MySqlException;
import com.hcmut.learningsystemserverrest.repository.SubclassRepository;
import com.hcmut.learningsystemserverrest.service.dto.StudentOfSubclassDTO;
import com.hcmut.learningsystemserverrest.service.dto.SubclassOfClassDTO;
import com.hcmut.learningsystemserverrest.service.dto.SubclassOfLecturerDTO;
import com.hcmut.learningsystemserverrest.service.dto.SubclassOfStudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubclassService {
    @Autowired
    private SubclassRepository subclassRepository;

    public void createSubclass(String id, String csemester, String cYear, String cType,
                               String csubjectID, String lecturerID) {
        try {
            subclassRepository.createSubclass(id, csemester, cYear, cType, csubjectID, lecturerID);
        } catch (DataIntegrityViolationException ex) {
            throw new MySqlException(ex.getMessage());
        }
    }

    public List<SubclassOfClassDTO> getSBOfClassInSemester(String subjectID, String semester) {
        return subclassRepository.getSBOfClassInSemester(subjectID, semester);
    }

    public List<SubclassOfStudentDTO> getSubclassOfStudent(String studentID) {
        return subclassRepository.getSubclassOfStudent(studentID);
    }

    public List<SubclassOfLecturerDTO> getSubclassOfLecturer(String lecturerID) {
        return subclassRepository.getSubclassOfLecturer(lecturerID);
    }

    public List<StudentOfSubclassDTO> getStudentsOfSubclass(String subclassID, String semester, String subjectID) {
        return subclassRepository.getStudentsOfSubclass(subclassID, semester, subjectID);
    }
}
