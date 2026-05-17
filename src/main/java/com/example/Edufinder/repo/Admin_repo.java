package com.example.Edufinder.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Edufinder.entity.Admin_entity;

@Repository
public interface Admin_repo extends JpaRepository<Admin_entity, Integer> {

    Optional<Admin_entity> findByEmailAndPassword(
            String email,
            String password);
}
