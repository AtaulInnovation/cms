package com.cms.repository;

import com.cms.entity.Contact;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer> {

    @Query(value = "select * from contact where (first_name in (?1) or coalesce(?1) is null) and " +
            "(last_name in (?2) or coalesce(?2) is null) and " +
            "(email in (?3) or coalesce(?3) is null)", nativeQuery = true)
    List<Contact> findContactsByFilter(List<String> firstName, List<String> lastName, List<String> email, Pageable pageable);
}
