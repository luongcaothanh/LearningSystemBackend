package com.hcmut.learningsystemserverrest.repository;

import com.hcmut.learningsystemserverrest.domain.StudentStatus;
import com.hcmut.learningsystemserverrest.domain.compositeId.StudentStatusId;
import com.hcmut.learningsystemserverrest.service.dto.StudentStatusDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentStatusRepository extends JpaRepository<StudentStatus, StudentStatusId> {
    @Query(value = "CALL createStudentStatus(?1,?2,?3,?4)", nativeQuery = true)
    void createStudentStatus(String studentID, String semester,
                             String learningStatus, Integer registeredCreditsNo);

    @Query(value = "CALL getStatusOfStudent(?1)", nativeQuery = true)
    List<StudentStatusDTO> getStatusOfStudent(String studentID);

    @Query(value = "CALL getStudentStatusOfSemester(?1,?2)", nativeQuery = true)
    StudentStatusDTO getStudentStatusOfSemester(String studentID, String semester);
}
