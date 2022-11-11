package com.hcmut.learningsystemserverrest.repository;

import com.hcmut.learningsystemserverrest.domain.Student;
import com.hcmut.learningsystemserverrest.service.dto.StudentCreatedDTO;
import com.hcmut.learningsystemserverrest.service.dto.StudentInfoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    @Query(value = "CALL getAllStudent();", nativeQuery = true)
    List<StudentInfoDTO> getAllStudent();

    @Query(value = "CALL getStudentInfo(?1);", nativeQuery = true)
    StudentInfoDTO getStudentInfo(String personID);

    @Query(value = "CALL createStudent(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11)", nativeQuery = true)
    StudentCreatedDTO createStudent(String idCard, String gender, String fName,
                                    String lName, LocalDate doB, String email,
                                    String studentID, String admissionYear, String facultyName,
                                    String username, String password);
}
