package com.hcmut.learningsystemserverrest.repository;

import com.hcmut.learningsystemserverrest.domain.Subclass;
import com.hcmut.learningsystemserverrest.domain.compositeId.SubclassId;
import com.hcmut.learningsystemserverrest.service.dto.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubclassRepository extends JpaRepository<Subclass, SubclassId> {
    @Query(value = "CALL createSubclass(?1,?2,?3,?4,?5,?6);", nativeQuery = true)
    void createSubclass(String id, String csemester, String cYear, String cType,
                        String csubjectID, String lecturerID);

    @Query(value = "CALL getSBOfClassInSemester(?1,?2);", nativeQuery = true)
    List<SubclassOfClassDTO> getSBOfClassInSemester(String subjectID, String semester);

    @Query(value = "CALL getSubclassOfStudent(?1);", nativeQuery = true)
    List<SubclassOfStudentDTO> getSubclassOfStudent(String studentID);

    @Query(value = "CALL getSubclassOfLecturer(?1);", nativeQuery = true)
    List<SubclassOfLecturerDTO> getSubclassOfLecturer(String lecturerID);

    @Query(value = "CALL getStudentsOfSubclass(?1,?2,?3);", nativeQuery = true)
    List<StudentOfSubclassDTO> getStudentsOfSubclass(String subclassID, String semester, String subjectID);

    @Query(value = "CALL getSubclassOfSubject(?1);", nativeQuery = true)
    List<SubclassOfSubjectDTO> getSubclassOfSubject(String subjectID);

    @Query(value = "CALL searchSubclassOfSubject(?1);", nativeQuery = true)
    List<SubclassOfSubjectDTO> searchSubclassOfSubject(String keyword);
}
