package com.hcmut.learningsystemserverrest.repository;

import com.hcmut.learningsystemserverrest.domain.AAOEmployee;
import com.hcmut.learningsystemserverrest.domain.enumeration.GENDER;
import com.hcmut.learningsystemserverrest.service.dto.EmployeeCreatedDTO;
import com.hcmut.learningsystemserverrest.service.dto.EmployeeInfoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AAOEmployeeRepository extends JpaRepository<AAOEmployee, String> {
    @Query(value = "CALL getAAOInfo(?1);", nativeQuery = true)
    EmployeeInfoDTO getAAOInfo(String personID);

    @Query(value = "CALL createAAOEmployee(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)", nativeQuery = true)
    EmployeeCreatedDTO createAAOEmployee(String idCard, String gender, String fName,
                                         String lName, LocalDate doB, String email,
                                         String employeeID, String facultyName,
                                         String username, String password);
}
