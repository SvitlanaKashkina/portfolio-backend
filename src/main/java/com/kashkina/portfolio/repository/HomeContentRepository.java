package com.kashkina.portfolio.repository;

import com.kashkina.portfolio.entity.HomeContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeContentRepository extends JpaRepository<HomeContent, Long> {
}

