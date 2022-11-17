package com.hcmut.learningsystemserverrest.repository;

import com.hcmut.learningsystemserverrest.domain.PersonPhone;
import com.hcmut.learningsystemserverrest.domain.compositeId.PersonPhoneId;
import com.hcmut.learningsystemserverrest.service.dto.PersonPhoneDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonPhoneRepository extends JpaRepository<PersonPhone, PersonPhoneId> {
    @Query(value = "CALL createPersonPhone(?1,?2);", nativeQuery = true)
    void createPersonPhone(String personID, String phoneNumber);

    @Query(value = "CALL getPersonPhone(?1);", nativeQuery = true)
    PersonPhoneDTO getPersonPhone(String personID);
}
