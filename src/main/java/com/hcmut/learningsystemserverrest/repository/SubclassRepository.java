package com.hcmut.learningsystemserverrest.repository;

import com.hcmut.learningsystemserverrest.domain.Subclass;
import com.hcmut.learningsystemserverrest.domain.compositeId.SubclassId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubclassRepository extends JpaRepository<Subclass, SubclassId> {
    @Query(value = "CALL createSubclass(?1,?2,?3,?4,?5,?6);", nativeQuery = true)
    void createSubclass(String id, String csemester, String cYear, String cType,
                        String csubjectID, String lecturerID);
}
