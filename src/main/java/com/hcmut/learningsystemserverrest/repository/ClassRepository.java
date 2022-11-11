package com.hcmut.learningsystemserverrest.repository;

import com.hcmut.learningsystemserverrest.domain.Class;
import com.hcmut.learningsystemserverrest.domain.compositeId.ClassId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class, ClassId> {
    @Query(value = "CALL createClass(?1,?2,?3,?4);", nativeQuery = true)
    void createClass(String semester, String classYear, String classType, String subjectID);
}
