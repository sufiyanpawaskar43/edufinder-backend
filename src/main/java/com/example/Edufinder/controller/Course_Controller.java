package com.example.Edufinder.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Edufinder.Service.Course_Service;
import com.example.Edufinder.entity.Course_entity;

@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "http://localhost:3000")
public class Course_Controller {

    @Autowired
    private Course_Service cs;

    // ================= GET ALL COURSES =================
    @GetMapping("/get")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(cs.getAll());
    }

    // ================= GET COURSE BY ID (DETAIL PAGE) =================
    @GetMapping("/getby/{id}")
    public ResponseEntity<Course_entity> getById(@PathVariable Integer id) {

        Optional<Course_entity> course = cs.getById(id);

        return course
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ================= ADD COURSE =================
    @PostMapping("/add/{instituteId}")
    public ResponseEntity<?> add(@PathVariable Integer instituteId,
                                 @RequestBody Course_entity c) {

        Course_entity saved = cs.add(instituteId, c);

        if (saved == null) {
            return ResponseEntity.badRequest().body("Institute not found");
        }
        return ResponseEntity.ok(saved);
    }

    // ================= GET COURSES BY INSTITUTE =================
    @GetMapping("/institute/{id}")
    public ResponseEntity<?> getByInstitute(@PathVariable Integer id) {
        return ResponseEntity.ok(cs.getByInstitute(id));
    }

    // ================= DELETE COURSE =================
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        return cs.delete(id)
                ? ResponseEntity.ok("Course deleted")
                : ResponseEntity.notFound().build();
    }
    
 // ================= UPDATE COURSE =================
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(
            @PathVariable Integer id,
            @RequestBody Course_entity c) {

        Course_entity updated = cs.update(id, c);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    
}
