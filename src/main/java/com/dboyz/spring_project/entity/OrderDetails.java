package com.dboyz.spring_project.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_details")
public class OrderDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "order_number", nullable = false)
  private String orderNumber;

  @Column(name = "product_id", nullable = false)
  private int productId;

  @Column(name = "product_name", nullable = false)
  private String productName;

  @Column(name = "price", nullable = false)
  private int price;

  @Column(name = "created_at", nullable = false, updatable = false)
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(name = "updated_at", nullable = false)
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  // Default constructor
  public OrderDetails() {
  }

  // Prameterized constructor
  public OrderDetails(String orderNumber, int productId, String productName, int price) {
    this.orderNumber = orderNumber;
    this.productId = productId;
    this.productName = productName;
    this.price = price;
  }

  // getters
  public Long getId() {
    return id;
  }

  public String getOrderNumber() {
    return orderNumber;
  }

  public int getProductId() {
    return productId;
  }

  public String getProductName() {
    return productName;
  }

  public int getPrice() {
    return price;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  // Setters
  public void setId(Long id) {
    this.id = id;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }
}
