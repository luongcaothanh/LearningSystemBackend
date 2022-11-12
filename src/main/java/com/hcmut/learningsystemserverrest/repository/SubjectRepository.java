package com.hcmut.learningsystemserverrest.repository;

import com.hcmut.learningsystemserverrest.domain.Subject;
import com.hcmut.learningsystemserverrest.service.dto.SubjectDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {
    @Query(value = "CALL createSubject(?1,?2,?3,?4,?5,?6);", nativeQuery = true)
    void createSubject(String id, String subjectName, Integer creditsNo,
                       String subjectStatus, String facultyName, String lecturerID);

    @Query(value = "CALL prerequisiteSubject(?1,?2);", nativeQuery = true)
    void createPrerequisite(String subjectID, String preSubjectID);

    @Query(value = "CALL getAllSubject();", nativeQuery = true)
    List<SubjectDTO> getAllSubject();

    @Query(value = "CALL getSubjectOfFaculty(?1);", nativeQuery = true)
    List<SubjectDTO> getSubjectOfFaculty(String facultyName);

    @Query(value = "CALL closeSubject(?1);", nativeQuery = true)
    void closeSubject(String subjectID);

    @Query(value = "CALL openSubject(?1);", nativeQuery = true)
    void openSubject(String subjectID);
}
