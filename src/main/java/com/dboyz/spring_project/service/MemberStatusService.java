package com.dboyz.spring_project.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dboyz.spring_project.dto.MemberStatusResponse;
import com.dboyz.spring_project.entity.MemberStatus;
import com.dboyz.spring_project.entity.OrderHistory;
import com.dboyz.spring_project.repository.MemberStatusRepository;
import com.dboyz.spring_project.repository.OrderRepository;

// 会員ステータス検索のビジネスロジックを実装するサービスクラス

@Service
public class MemberStatusService {
  private final MemberStatusRepository memberStatusRepository;
  private final OrderRepository orderRepository;

  @Autowired
  public MemberStatusService(MemberStatusRepository memberStatusRepository, OrderRepository orderRepository) {
    this.memberStatusRepository = memberStatusRepository;
    this.orderRepository = orderRepository;
  }

  @Transactional
  public MemberStatusResponse calculateAndUpdateMemberStatus(UUID userId, String OrderNumber) {
    OrderHistory orderHistory = orderRepository.findByOrderNumber(OrderNumber)
        .orElseThrow(() -> new RuntimeException("Order not found for order number: " + OrderNumber));

    int earnedPoints = calculatePoints(orderHistory.getTotalPrice());

    MemberStatus memberStatus = memberStatusRepository.findByUserId(userId)
        .orElse(new MemberStatus(userId, 0, "Bronze"));
    memberStatus.setTotalPoints(memberStatus.getTotalPoints() + earnedPoints);

    int totalPointsLast3Month = calculateTotalPointsLast3Month(userId);
    String newRank = determinRank(totalPointsLast3Month);
    memberStatus.setRank(newRank);

    memberStatusRepository.save(memberStatus);

    return new MemberStatusResponse(userId, memberStatus.getTotalPoints(), newRank);

  }

  private int calculatePoints(int totalPrice) {
    return totalPrice / 100; // 1% of totalPrice
  }

  private int calculateTotalPointsLast3Month(UUID userId) {
    LocalDateTime threeMonthAgo = LocalDateTime.now().minusMonths(3);
    return orderRepository.sumPointsForUserSince(userId, threeMonthAgo);
  }

  private String determinRank(int points) {
    if (points >= 50) {
      return "Gold";
    } else if (points >= 10) {
      return "Silver";
    } else {
      return "Bronze";
    }
  }
}
