package com.dboyz.spring_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dboyz.spring_project.entity.OrderDetails;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
  // Add findbyorderNumber method to retrieve order details by order number
  List<OrderDetails> findByOrderNumber(String orderNumber);
}
