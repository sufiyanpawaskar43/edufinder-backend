package com.example.Edufinder.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Edufinder.Service.College_Service;
import com.example.Edufinder.entity.College_entity;

@RestController
@RequestMapping("/college")
@CrossOrigin(origins = "http://localhost:3000")
public class College_controller {

    @Autowired
    private College_Service cs;

    @GetMapping("/hello")
    public String welcome() {
        return "Welcome to EduFinder College API";
    }

    @GetMapping("/get")
    public List<College_entity> getAll() {
        return cs.getAllColleges();
    }

    @GetMapping("/getby/{id}")
    public ResponseEntity<College_entity> getById(@PathVariable Integer id) {
        Optional<College_entity> c = cs.getById(id);
        return c.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public String add(@RequestBody College_entity c) {
        cs.addCollege(c);
        return "College added successfully";
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<College_entity> update(@PathVariable Integer id,
                                                 @RequestBody College_entity c) {
        College_entity updated = cs.updateById(id, c);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/patch/{id}")
    public ResponseEntity<College_entity> patch(@PathVariable Integer id,
                                                @RequestBody College_entity c) {
        College_entity patched = cs.patchById(id, c);
        if (patched == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(patched);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        return cs.deleteById(id)
                ? "College deleted successfully"
                : "College not found";
    }

    @GetMapping("/city/{city}")
    public List<College_entity> getByCity(@PathVariable String city) {
        return cs.getByCity(city);
    }

    @GetMapping("/stream/{stream}")
    public List<College_entity> getByStream(@PathVariable String stream) {
        return cs.getByStream(stream);
    }
}
