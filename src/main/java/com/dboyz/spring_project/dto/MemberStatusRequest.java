package com.dboyz.spring_project.dto;

import java.util.UUID;

// フロントエンドからの会員検索を受け取るためのDTOクラス
// どのユーザのどの注文に対する会員ステータスを取得するかを指定するために使用される

public class MemberStatusRequest {
  private UUID userId;
  private String orderNumber;

  // default constructor
  public MemberStatusRequest() {
  }

  // parameterized constructor
  public MemberStatusRequest(UUID userId, String orderNumber) {
    this.userId = userId;
    this.orderNumber = orderNumber;
  }

  // getters and setters
  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

}
