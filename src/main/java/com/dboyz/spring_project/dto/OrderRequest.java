package com.dboyz.spring_project.dto;

import java.util.List;
import java.util.UUID;

public class OrderRequest {
  private UUID userId;
  private String userName;
  private int totalPrice;
  private int totalQuantity;
  private List<OrderItem> orderItems;

  // default constructor
  public OrderRequest() {
  }

  // parameterized constructor
  public OrderRequest(UUID userId, String userName, int totalPrice, int totalQuantity, List<OrderItem> orderItems) {
    this.userId = userId;
    this.userName = userName;
    this.totalPrice = totalPrice;
    this.totalQuantity = totalQuantity;
    this.orderItems = orderItems;
  }

  // getters and setters
  public UUID getUserId() {
    return userId;
  }

  public String getUserName() {
    return userName;
  }

  public int getTotalPrice() {
    return totalPrice;
  }

  public int getTotalQuantity() {
    return totalQuantity;
  }

  public List<OrderItem> getOrderItems() {
    return orderItems;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setTotalPrice(int totalPrice) {
    this.totalPrice = totalPrice;
  }

  public void setTotalQuantity(int totalQuantity) {
    this.totalQuantity = totalQuantity;
  }

  public void setOrderItems(List<OrderItem> orderItems) {
    this.orderItems = orderItems;
  }

}
