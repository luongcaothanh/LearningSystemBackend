package com.hcmut.learningsystemserverrest.repository;

import com.hcmut.learningsystemserverrest.domain.Subclass;
import com.hcmut.learningsystemserverrest.domain.compositeId.SubclassId;
import com.hcmut.learningsystemserverrest.service.dto.StudentOfSubclassDTO;
import com.hcmut.learningsystemserverrest.service.dto.SubclassOfClassDTO;
import com.hcmut.learningsystemserverrest.service.dto.SubclassOfLecturerDTO;
import com.hcmut.learningsystemserverrest.service.dto.SubclassOfStudentDTO;
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

    @Query(value = "CALL getSCOfStudentInSemester(?1,?2);", nativeQuery = true)
    List<SubclassOfStudentDTO> getSCOfStudentInSemester(String studentID, String semester);

    @Query(value = "CALL getSCOfLecturerInSemester(?1,?2);", nativeQuery = true)
    List<SubclassOfLecturerDTO> getSCOfLecturerInSemester(String lecturerID, String semester);

    @Query(value = "CALL getStudentsOfSubclass(?1,?2,?3);", nativeQuery = true)
    List<StudentOfSubclassDTO> getStudentsOfSubclass(String subclassID, String semester, String subjectID);
}
