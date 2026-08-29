package com.dboyz.spring_project.dto;

import java.util.List;

public class OrderDTO {
  private String orderDate;
  private String orderNumber;
  private int totalPrice;
  private int totalQuantity;
  private List<OrderItem> orderItems;

  // default constructor
  public OrderDTO() {
  }

  // constructor
  public OrderDTO(String orderDate, String orderNumber, int totalPrice, int totalQuantity, List<OrderItem> orderItems) {
    this.orderDate = orderDate;
    this.orderNumber = orderNumber;
    this.totalPrice = totalPrice;
    this.totalQuantity = totalQuantity;
    this.orderItems = orderItems;
  }

  public String getOrderDate() {
    return orderDate;
  }

  public String getOrderNumber() {
    return orderNumber;
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

  public void setOrderDate(String orderDate) {
    this.orderDate = orderDate;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
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
