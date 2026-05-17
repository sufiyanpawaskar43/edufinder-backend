package com.example.Edufinder.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Edufinder.Service.Institute_service;
import com.example.Edufinder.entity.Institute_entity;

@RestController
@RequestMapping("/institute")
@CrossOrigin(origins = "http://localhost:3000")
public class Institute_controller {

    @Autowired
    private Institute_service is;

    @GetMapping("/get")
    public Object getAll() {
        return is.getAll();
    }

    @GetMapping("/getby/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Optional<Institute_entity> i = is.getById(id);
        return i.isPresent() ? ResponseEntity.ok(i.get())
                             : ResponseEntity.notFound().build();
    }

    @PostMapping("/add")
    public String add(@RequestBody Institute_entity i) {
        is.add(i);
        return "Institute added successfully";
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,
                                    @RequestBody Institute_entity i) {
        Institute_entity updated = is.update(id, i);
        return updated == null ? ResponseEntity.notFound().build()
                               : ResponseEntity.ok(updated);
    }

    @PatchMapping("/patch/{id}")
    public ResponseEntity<?> patch(@PathVariable Integer id,
                                   @RequestBody Institute_entity i) {
        Institute_entity patched = is.patch(id, i);
        return patched == null ? ResponseEntity.notFound().build()
                               : ResponseEntity.ok(patched);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        return is.delete(id) ? "Institute deleted" : "Institute not found";
    }
}
