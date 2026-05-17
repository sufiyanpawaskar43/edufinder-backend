package com.example.Edufinder.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Edufinder.entity.College_entity;

@Repository
public interface College_repo extends JpaRepository<College_entity, Integer> {

    List<College_entity> findByCity(String city);
    List<College_entity> findByStream(String stream);
}
