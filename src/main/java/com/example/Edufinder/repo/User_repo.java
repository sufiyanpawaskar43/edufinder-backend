package com.example.Edufinder.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Edufinder.entity.User_entity;
@Repository
public interface User_repo extends JpaRepository<User_entity, Integer> {

    User_entity findByEmail(String email);

    User_entity findByEmailAndPassword(String email, String password);
}

