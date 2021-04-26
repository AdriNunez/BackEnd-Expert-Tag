package com.example.repository;

import com.example.model.Expert;
import com.example.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertRepository extends JpaRepository<Expert,Long> {

}
