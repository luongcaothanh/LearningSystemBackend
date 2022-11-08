package com.hcmut.learningsystemserverrest.repository;

import com.hcmut.learningsystemserverrest.domain.AAOEmployee;
import com.hcmut.learningsystemserverrest.service.dto.EmployeeInfoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AAOEmployeeRepository extends JpaRepository<AAOEmployee, String> {
    @Query(value = "CALL getAAOInfo(?1);", nativeQuery = true)
    EmployeeInfoDTO getAAOInfo(String personID);
}
