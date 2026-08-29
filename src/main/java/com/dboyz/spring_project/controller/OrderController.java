package com.dboyz.spring_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dboyz.spring_project.dto.OrderHistoryResponse;
import com.dboyz.spring_project.dto.OrderRequest;
import com.dboyz.spring_project.dto.OrderResponse;
import com.dboyz.spring_project.service.OrderService;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
  private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
  private final OrderService orderService;

  @Autowired
  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping
  public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
    try {
      OrderResponse orderResponse = orderService.createOrder(orderRequest);
      return ResponseEntity.status(200).body(orderResponse);
    } catch (Exception e) {
      logger.error("Error occurred while creating order", e);
      OrderResponse errorResponse = new OrderResponse(null, "error", "Failed to create order");
      return ResponseEntity.status(500).body(errorResponse);
    }
  }

  @GetMapping
  public ResponseEntity<OrderHistoryResponse> getOrderHistory(@RequestParam UUID userId,
      @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
    try {
      OrderHistoryResponse orderHistoryResponse = orderService.getOrderHistory(userId, page, size);
      return ResponseEntity.ok(orderHistoryResponse);
    } catch (Exception e) {
      logger.error("Error occurred while fetching order history", e);
      OrderHistoryResponse errorResponse = new OrderHistoryResponse(null, null);
      return ResponseEntity.status(500).body(errorResponse);
    }
  }

}
