package com.example.massproject.repository;

import com.example.massproject.model.ComplaintEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<ComplaintEntity, String> {
}
