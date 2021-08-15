package com.hashcode.placementify.repository;

import com.hashcode.placementify.model.StudentCodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DataFormRepository extends JpaRepository<StudentCodes, String> {

    Boolean findByCodeAndEmailId(String code, String emailid);
}
