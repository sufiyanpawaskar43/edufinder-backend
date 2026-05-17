package com.example.Edufinder.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.Edufinder.Service.Admin_Service;
import com.example.Edufinder.entity.Admin_entity;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class Admin_Controller {

    @Autowired
    private Admin_Service adminService;

    // ================= ADMIN LOGIN =================
    @GetMapping("/login")
    public ResponseEntity<?> login(
            @RequestParam String email,
            @RequestParam String password) {

        Optional<Admin_entity> admin =
                adminService.login(email, password);

        if (admin.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid admin credentials");
        }

        Admin_entity a = admin.get();
        a.setPassword(null);

        return ResponseEntity.ok(a);
    }

    // ================= DASHBOARD COUNTS =================
    @GetMapping("/dashboard/counts")
    public ResponseEntity<Map<String, Long>> getDashboardCounts() {

        Map<String, Long> counts = new HashMap<>();
        counts.put("users", adminService.countUsers());
        counts.put("colleges", adminService.countColleges());
        counts.put("institutes", adminService.countInstitutes());

        return ResponseEntity.ok(counts);
    }
    
    
}
