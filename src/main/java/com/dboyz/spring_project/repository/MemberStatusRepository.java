package com.dboyz.spring_project.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dboyz.spring_project.entity.MemberStatus;

@Repository
public interface MemberStatusRepository extends JpaRepository<MemberStatus, UUID> {
  // Add FindbyUserId method to retrieve member status by user ID
  Optional<MemberStatus> findByUserId(UUID userId);

}
