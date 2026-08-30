package com.dboyz.spring_project.repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dboyz.spring_project.entity.OrderHistory;

@Repository
public interface OrderRepository extends JpaRepository<OrderHistory, String> {
  // Add findByOrderNumber method to retrieve order history by order number
  Optional<OrderHistory> findByOrderNumber(String orderNumber);

  // Add findByUserId method to retrieve order history by user ID
  Page<OrderHistory> findByUserId(UUID userId, Pageable pageable);

  // Add sumPointsForUserSince method
  @Query("SELECT SUM(o.totalPrice) / 100 FROM OrderHistory o WHERE o.userId = :userId AND o.orderDate >= :sinceDate")
  int sumPointsForUserSince(@Param("userId") UUID userId, @Param("sinceDate") LocalDateTime sinceDate);
}