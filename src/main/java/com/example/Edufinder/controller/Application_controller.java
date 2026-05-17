package com.example.Edufinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Edufinder.Service.Application_service;
import com.example.Edufinder.entity.Application_entity;

@RestController
@RequestMapping("/application")
@CrossOrigin(origins = "http://localhost:3000")
public class Application_controller {

    @Autowired
    private Application_service service;

    /* ================= APPLY ================= */
    @PostMapping("/apply")
    public ResponseEntity<Application_entity> apply(
            @RequestBody Application_entity app) {

        app.setStatus("PENDING"); // default
        Application_entity saved = service.apply(app);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    /* ================= UPDATE STATUS ================= */
    @PutMapping("/status/{id}")
    public ResponseEntity<Application_entity> updateStatus(
            @PathVariable int id,
            @RequestParam String status) {

        Application_entity updated = service.updateStatus(id, status);
        return ResponseEntity.ok(updated);
    }



    /* ================= ADMIN: GET ALL ================= */
    @GetMapping("/get")
    public ResponseEntity<List<Application_entity>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    /* ================= ADMIN: DELETE ================= */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}
