package com.example.Edufinder.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Edufinder.entity.Course_entity;

@Repository
public interface Course_repo extends JpaRepository<Course_entity, Integer> {

    List<Course_entity> findByInstituteId(Integer instituteId);
}
