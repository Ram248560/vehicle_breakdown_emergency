package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.BreakdownRequest;

@Repository
public interface BreakdownRequestRepository extends JpaRepository<BreakdownRequest, Long> {
}
