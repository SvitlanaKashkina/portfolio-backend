package com.kashkina.portfolio.repository;

import com.kashkina.portfolio.entity.AboutMe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AboutMeRepository extends JpaRepository<AboutMe, Long> {

    Optional<AboutMe> findBySectionKey(String sectionKey);
}
