package com.dboyz.spring_project.dto;

public class OrderResponse {
  private String orderNumber;
  private String status;
  private String message;

  // default constructor
  public OrderResponse() {
  }

  // parameterized constructor
  public OrderResponse(String orderNumber, String status, String message) {
    this.orderNumber = orderNumber;
    this.status = status;
    this.message = message;
  }

  // getters and setters
  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
