package com.dboyz.spring_project.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "order_history")
@Entity
public class OrderHistory {
  @Id
  @Column(name = "order_number", nullable = false)
  private String orderNumber;

  @Column(name = "order_date", nullable = false)
  private Date orderDate;

  @Column(name = "user_id", nullable = false)
  private UUID userId;

  @Column(name = "user_name", nullable = false)
  private String userName;

  @Column(name = "total_price", nullable = false)
  private int totalPrice;

  @Column(name = "total_quantity", nullable = false)
  private int totalQuantity;

  @Column(name = "earned_points", nullable = false)
  private int earnedPoints;

  @Column(name = "created_at", nullable = false, updatable = false)
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(name = "updated_at", nullable = false)
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  // Default constructor
  public OrderHistory() {
  }

  // Parameterized constructor
  public OrderHistory(String orderNumber, Date orderDate, UUID userId, String userName, int totalPrice,
      int totalQuantity, int earnedPoints) {
    this.orderNumber = orderNumber;
    this.orderDate = orderDate;
    this.userId = userId;
    this.userName = userName;
    this.totalPrice = totalPrice;
    this.totalQuantity = totalQuantity;
    this.earnedPoints = earnedPoints;
  }

  public String getOrderNumber() {
    return orderNumber;
  }

  public Date getOrderDate() {
    return orderDate;
  }

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

  public int getEarnedPoints() {
    return earnedPoints;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
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

  public void setEarnedPoints(int earnedPoints) {
    this.earnedPoints = earnedPoints;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

}
