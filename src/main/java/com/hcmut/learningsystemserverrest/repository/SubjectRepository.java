package com.hcmut.learningsystemserverrest.repository;

import com.hcmut.learningsystemserverrest.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {
    @Query(value = "CALL createSubject(?1,?2,?3,?4,?5,?6);", nativeQuery = true)
    void createSubject(String id, String subjectName, Integer creditsNo,
                       String subjectStatus, String facultyName, String lecturerID);
}
