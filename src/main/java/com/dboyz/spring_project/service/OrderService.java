package com.dboyz.spring_project.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dboyz.spring_project.dto.OrderDTO;
import com.dboyz.spring_project.dto.OrderHistoryResponse;
import com.dboyz.spring_project.dto.OrderItem;
import com.dboyz.spring_project.dto.OrderRequest;
import com.dboyz.spring_project.dto.OrderResponse;
import com.dboyz.spring_project.dto.PageableDTO;
import com.dboyz.spring_project.entity.OrderDetails;
import com.dboyz.spring_project.entity.OrderHistory;
import com.dboyz.spring_project.repository.OrderDetailsRepository;
import com.dboyz.spring_project.repository.OrderRepository;

@Service
public class OrderService {
  private final OrderRepository orderRepository;
  private final OrderDetailsRepository orderDetailsRepository;

  @Autowired
  public OrderService(OrderRepository orderRepository, OrderDetailsRepository orderDetailsRepository) {
    this.orderRepository = orderRepository;
    this.orderDetailsRepository = orderDetailsRepository;
  }

  @Transactional
  public OrderResponse createOrder(OrderRequest orderRequest) {
    // Implement the logic to create an order and save it to the database
    // You can use orderRepository and orderDetailsRepository to save the order and
    // its details
    // Return an OrderResponse object with the order number, status, and message
    String orderNumber = generateOrderNumber();
    LocalDateTime orderDate = LocalDateTime.now();

    OrderHistory orderHistory = new OrderHistory();
    orderHistory.setOrderNumber(orderNumber);
    orderHistory.setOrderDate(java.sql.Date.valueOf(orderDate.toLocalDate()));
    orderHistory.setUserId(orderRequest.getUserId());
    orderHistory.setUserName(orderRequest.getUserName());
    orderHistory.setTotalPrice(orderRequest.getTotalPrice());
    orderHistory.setTotalQuantity(orderRequest.getTotalQuantity());
    orderHistory.setEarnedPoints(calculateEarnedPoints(orderRequest.getTotalPrice()));

    orderRepository.save(orderHistory);

    for (OrderItem item : orderRequest.getOrderItems()) {
      OrderDetails orderDetails = new OrderDetails();
      orderDetails.setOrderNumber(orderNumber);
      orderDetails.setProductId(item.getProductId());
      orderDetails.setProductName(item.getProductName());
      orderDetails.setPrice(item.getPrice());
      orderDetailsRepository.save(orderDetails);
    }

    return new OrderResponse(orderNumber, "success", "Order created successfully");
  }

  private String generateOrderNumber() {
    // Implement the logic to generate a unique order number
    // You can use a combination of timestamp and random number or any other
    // approach
    return "ORD-" + UUID.randomUUID().toString();
  }

  private int calculateEarnedPoints(int totalPrice) {
    // Implement the logic to calculate earned points based on the total price
    // You can define your own rules for calculating points
    return totalPrice / 100; // Example: 1 point for every $10 spent
  }

  public OrderHistoryResponse getOrderHistory(UUID userId, int page, int size) {
    PageRequest pagerequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "orderDate"));
    Page<OrderHistory> orderHistoryPage = orderRepository.findByUserId(userId, pagerequest);

    List<OrderDTO> orderDTOs = orderHistoryPage.getContent().stream()
        .map(this::convertToOrderDTO)
        .collect(Collectors.toList());

    PageableDTO pageableDTO = new PageableDTO(
        orderHistoryPage.getNumber(),
        orderHistoryPage.getSize(),
        orderHistoryPage.getTotalElements(),
        orderHistoryPage.getTotalPages());

    return new OrderHistoryResponse(orderDTOs, pageableDTO);

  }

  private OrderDTO convertToOrderDTO(OrderHistory orderHistory) {
    List<OrderDetails> orderDetails = orderDetailsRepository.findByOrderNumber(orderHistory.getOrderNumber());

    List<OrderItem> orderItems = orderDetails.stream()
        .map(this::convertToOrderItem)
        .collect(Collectors.toList());

    return new OrderDTO(
        orderHistory.getOrderDate().toString(),
        orderHistory.getOrderNumber(),
        orderHistory.getTotalPrice(),
        orderHistory.getTotalQuantity(),
        orderItems);
  }

  private OrderItem convertToOrderItem(OrderDetails orderDetails) {
    return new OrderItem(
        orderDetails.getProductId(),
        orderDetails.getProductName(),
        orderDetails.getPrice());
  }
}
