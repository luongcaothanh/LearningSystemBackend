package com.hcmut.learningsystemserverrest.repository;

import com.hcmut.learningsystemserverrest.domain.Manager;
import com.hcmut.learningsystemserverrest.service.dto.EmployeeCreatedDTO;
import com.hcmut.learningsystemserverrest.service.dto.EmployeeInfoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, String> {
    @Query(value = "CALL getManagerInfo(?1);", nativeQuery = true)
    EmployeeInfoDTO getManagerInfo(String personID);

    @Query(value = "CALL createManager(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)", nativeQuery = true)
    EmployeeCreatedDTO createManager(String idCard, String gender, String fName,
                                         String lName, LocalDate doB, String email,
                                         String employeeID, String facultyName,
                                         String username, String password);

    @Query(value = "CALL getAllManager();", nativeQuery = true)
    List<EmployeeInfoDTO> getAllManager();
}
