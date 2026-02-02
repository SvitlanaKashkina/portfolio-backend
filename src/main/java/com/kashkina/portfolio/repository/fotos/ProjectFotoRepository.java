package com.kashkina.portfolio.repository.fotos;

import com.kashkina.portfolio.entity.projects.ProjectFoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectFotoRepository extends JpaRepository<ProjectFoto, Integer> {

    List<ProjectFoto> findAllById(Iterable<Integer> id);
}
