package com.example.Edufinder.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Edufinder.entity.Institute_entity;

import jakarta.transaction.Transactional;

@Repository
public interface Institute_repo extends JpaRepository<Institute_entity, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Institute_entity i SET i.fees = :fees, i.rating = :rating WHERE i.id = :id")
    int updateFeesAndRating(Integer id, Integer fees, Double rating);
}
