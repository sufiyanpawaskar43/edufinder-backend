package com.example.Edufinder.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Edufinder.entity.Application_entity;

public interface Application_repo 
    extends JpaRepository<Application_entity, Integer> {
}
