package com.hcmut.learningsystemserverrest.repository;

import com.hcmut.learningsystemserverrest.domain.Class;
import com.hcmut.learningsystemserverrest.domain.compositeId.ClassId;
import com.hcmut.learningsystemserverrest.service.dto.ClassDTO;
import com.hcmut.learningsystemserverrest.service.dto.ClassOfSubjectDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Class, ClassId> {
    @Query(value = "CALL createClass(?1,?2,?3,?4);", nativeQuery = true)
    void createClass(String semester, String classYear, String classType, String subjectID);

    @Query(value = "CALL getClassOfSubjectInSemester(?1);", nativeQuery = true)
    List<ClassOfSubjectDTO> getClassOfSubjectInSemester(String subjectID);

    @Query(value = "CALL getClassOfFaculty(?1);", nativeQuery = true)
    List<ClassDTO> getClassOfFaculty(String facultyName);

}
