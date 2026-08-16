package com.dboyz.spring_project.dto;

public class OrderItem {
  private int productId;
  private String productName;
  private int price;

  // default constructor
  public OrderItem() {
  }

  // parameterized constructor
  public OrderItem(int productId, String productName, int price) {
    this.productId = productId;
    this.productName = productName;
    this.price = price;
  }

  // getter
  public int getProductId() {
    return productId;
  }

  public String getProductName() {
    return productName;
  }

  public int getPrice() {
    return price;
  }

  // setter
  public void setProductId(int productId) {
    this.productId = productId;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public void setPrice(int price) {
    this.price = price;
  }

}
