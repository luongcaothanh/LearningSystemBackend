package com.hcmut.learningsystemserverrest.repository;

import com.hcmut.learningsystemserverrest.domain.Textbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TextbookRepository extends JpaRepository<Textbook, String> {
    @Query(value = "CALL createTextbook(?1,?2,?3,?4,?5,?6);", nativeQuery = true)
    void createTextbook(String id, String textbookName, String publishingHouse,
                        String publishingYear, String category, String authorName);
}
