package com.dboyz.spring_project.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dboyz.spring_project.entity.OrderHistory;

@Repository
public interface OrderRepository extends JpaRepository<OrderHistory, String> {
  // Add findByOrderNumber method to retrieve order history by order number
  Optional<OrderHistory> findByOrderNumber(String orderNumber);

  // Add findByUserId method to retrieve order history by user ID
  Page<OrderHistory> findByUserId(UUID userId, Pageable pageable);

}