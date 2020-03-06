package com.adreeana.oneteam.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTeamsDelegate extends JpaRepository<JpaTeam, Long> {
    JpaTeam findByName(String name);
}
