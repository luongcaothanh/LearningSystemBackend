package com.hcmut.learningsystemserverrest.repository;

import com.hcmut.learningsystemserverrest.domain.Employee;
import com.hcmut.learningsystemserverrest.service.dto.EmployeeInfoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Query(value = "CALL getAllEmployee();", nativeQuery = true)
    List<EmployeeInfoDTO> getAllEmployee();
}
