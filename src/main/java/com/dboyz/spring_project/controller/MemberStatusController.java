package com.dboyz.spring_project.controller;

import java.lang.reflect.Member;
import java.net.http.HttpResponse;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dboyz.spring_project.dto.MemberStatusRequest;
import com.dboyz.spring_project.dto.MemberStatusResponse;
import com.dboyz.spring_project.service.MemberStatusService;

@RestController
@RequestMapping("/api/member-status")
public class MemberStatusController {
  private static final Logger logger = LoggerFactory.getLogger(MemberStatusController.class);
  private final MemberStatusService memberStatusService;

  @Autowired
  public MemberStatusController(MemberStatusService memberStatusService) {
    this.memberStatusService = memberStatusService;
  }

  @PostMapping("/calculate")
  public ResponseEntity<MemberStatusResponse> calculateMemberStatus(@RequestBody MemberStatusRequest request) {
    try {
      MemberStatusResponse result = memberStatusService.calculateAndUpdateMemberStatus(request.getUserId(),
          request.getOrderNumber());
      return ResponseEntity.ok(result);
    } catch (Exception e) {
      logger.error("Error occurd while calculating member status", e);
      MemberStatusResponse errorResponse = new MemberStatusResponse(request.getUserId(), 0, "Error");
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
  }

  @GetMapping("/{userId}")
  public ResponseEntity<MemberStatusResponse> getMemberStatus(@PathVariable UUID userId) {
    try {
      MemberStatusResponse result = memberStatusService.getMemberStatus(userId);
      return ResponseEntity.ok(result);
    } catch (Exception e) {
      logger.error("Error occurred while retrieving member status", e);
      MemberStatusResponse errorResponse = new MemberStatusResponse(userId, 0, "Error");
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
  }
}
