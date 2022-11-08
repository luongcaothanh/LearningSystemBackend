package com.hcmut.learningsystemserverrest.repository;

import com.hcmut.learningsystemserverrest.domain.Student;
import com.hcmut.learningsystemserverrest.service.dto.StudentInfoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    @Query(value = "CALL getAllStudent();", nativeQuery = true)
    List<StudentInfoDTO> getAllStudent();
}
