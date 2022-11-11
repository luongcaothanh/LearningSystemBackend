package com.hcmut.learningsystemserverrest.repository;

import com.hcmut.learningsystemserverrest.domain.StudentStatus;
import com.hcmut.learningsystemserverrest.domain.compositeId.StudentStatusId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentStatusRepository extends JpaRepository<StudentStatus, StudentStatusId> {
    @Query(value = "CALL createStudentStatus(?1,?2,?3,?4)", nativeQuery = true)
    void createStudentStatus(String studentID, String semester,
                             String learningStatus, Integer registeredCreditsNo);
}
