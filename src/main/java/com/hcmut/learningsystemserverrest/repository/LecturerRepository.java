package com.hcmut.learningsystemserverrest.repository;

import com.hcmut.learningsystemserverrest.domain.Lecturer;
import com.hcmut.learningsystemserverrest.service.dto.LecturerInfoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, String> {
    @Query(value = "CALL getLecturerInfo(?1);", nativeQuery = true)
    LecturerInfoDTO getLecturerInfo(String personID);
}
