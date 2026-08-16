package com.dboyz.spring_project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dboyz.spring_project.entity.OrderHistory;

@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory, String> {
  // Add findByOrderNumber method to retrieve order history by order number
  Optional<OrderHistory> findByOrderNumber(String orderNumber);
}
