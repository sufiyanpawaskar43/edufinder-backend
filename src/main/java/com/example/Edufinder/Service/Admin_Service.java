package com.example.Edufinder.Service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Edufinder.entity.Admin_entity;
import com.example.Edufinder.repo.Admin_repo;
import com.example.Edufinder.repo.College_repo;
import com.example.Edufinder.repo.Institute_repo;
import com.example.Edufinder.repo.User_repo;

@Service
public class Admin_Service {

    @Autowired
    private Admin_repo adminRepo;

    @Autowired
    private User_repo userRepo;
    @Autowired
    private College_repo collegeRepo  ;
    @Autowired
    private Institute_repo instituteRepo;


    public long countUsers() {
        return userRepo.count();
    }

    public long countColleges() {
        return collegeRepo.count();
    }

    public long countInstitutes() {
        return instituteRepo.count();
    }
    // ADMIN LOGIN
    public Optional<Admin_entity> login(String email, String password) {
        return adminRepo.findByEmailAndPassword(email, password);
    }

    // ADMIN DASHBOARD
    public Object getAllAdmins() {
        return adminRepo.findAll();
    }
}
