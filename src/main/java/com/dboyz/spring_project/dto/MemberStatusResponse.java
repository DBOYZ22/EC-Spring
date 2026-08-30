package com.dboyz.spring_project.dto;

import java.util.UUID;

// フロントエンドに返す会員ステータスのレスポンスを表すDTOクラス

public class MemberStatusResponse {
  private UUID userId;
  private int totalPoints;
  private String rank;

  // default constructor
  public MemberStatusResponse() {
  }

  // parameterized constructor
  public MemberStatusResponse(UUID userId, int totalPoints, String rank) {
    this.userId = userId;
    this.totalPoints = totalPoints;
    this.rank = rank;
  }

  // getters and setters
  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public int getTotalPoints() {
    return totalPoints;
  }

  public void setTotalPoints(int totalPoints) {
    this.totalPoints = totalPoints;
  }

  public String getRank() {
    return rank;
  }

  public void setRank(String rank) {
    this.rank = rank;
  }

}
