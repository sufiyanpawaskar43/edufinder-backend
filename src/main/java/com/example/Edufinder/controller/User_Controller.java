package com.example.Edufinder.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.Edufinder.Service.User_Service;
import com.example.Edufinder.entity.User_entity;
import com.example.Edufinder.repo.User_repo;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class User_Controller {

    @Autowired
    private User_Service userService;

    @Autowired
    private User_repo userRepo;

    // ================= HELLO =================
    @GetMapping("/hello")
    public String welcome() {
        return "Welcome to EduFinder User API";
    }

    // ================= GET ALL USERS =================
    @GetMapping("/get")
    public List<User_entity> getAllUsers() {
        List<User_entity> all = userRepo.findAll();
        all.forEach(u -> u.setPassword(null));
        return all;
    }

    // ================= ADD USER =================
    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User_entity user) {
        user.setRole("USER");
        userService.adduser(user);
        return ResponseEntity.ok("User added successfully");
    }

    // ================= GET USER BY ID =================
    @GetMapping("/getby/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Optional<User_entity> user = userRepo.findById(id);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        user.get().setPassword(null);
        return ResponseEntity.ok(user.get());
    }

    // ================= LOGIN =================
    @GetMapping("/login")
    public ResponseEntity<?> login(
            @RequestParam String email,
            @RequestParam String password) {

        User_entity user = userRepo.findByEmail(email);

        if (user == null || !user.getPassword().equals(password)) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid email or password");
        }

        user.setPassword(null);
        return ResponseEntity.ok(user);
    }

    // ================= DELETE USER =================
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        if (!userRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userRepo.deleteById(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    // ================= ADMIN UPDATE USER (JSON) =================
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(
            @PathVariable Integer id,
            @RequestBody User_entity updatedUser) {

        Optional<User_entity> opt = userRepo.findById(id);
        if (opt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User_entity user = opt.get();

        // admin allowed fields
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setContact(updatedUser.getContact());
        user.setRole(updatedUser.getRole());

        // password optional
        if (updatedUser.getPassword() != null && !updatedUser.getPassword().isBlank()) {
            user.setPassword(updatedUser.getPassword());
        }

        User_entity saved = userRepo.save(user);
        saved.setPassword(null);

        return ResponseEntity.ok(saved);
    }

    // ================= PROFILE UPDATE (JSON ONLY) =================
    @PutMapping(
    	    value = "/profile/{id}",
    	    consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    	)
    	public ResponseEntity<User_entity> updateProfile(
    	        @PathVariable Integer id,
    	        @RequestParam("firstName") String firstName,
    	        @RequestParam("lastName") String lastName,
    	        @RequestParam("email") String email,
    	        @RequestParam(value = "image", required = false) MultipartFile image
    	) {

    	    Optional<User_entity> opt = userRepo.findById(id);

    	    if (opt.isEmpty()) {
    	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	    }

    	    User_entity user = opt.get();

    	    user.setName(firstName + " " + lastName);
    	    user.setEmail(email);

    	    if (image != null && !image.isEmpty()) {
    	        try {
    	            String fileName =
    	                    System.currentTimeMillis() + "_" + image.getOriginalFilename();

    	            String UPLOAD_DIR =
    	                    System.getProperty("user.dir") + "/uploads/users";

    	            Path uploadPath = Paths.get(UPLOAD_DIR);
    	            Files.createDirectories(uploadPath);

    	            Files.copy(
    	                    image.getInputStream(),
    	                    uploadPath.resolve(fileName),
    	                    StandardCopyOption.REPLACE_EXISTING
    	            );

    	            user.setImage(fileName);

    	        } catch (IOException e) {
    	            e.printStackTrace();
    	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    	        }
    	    }

    	    User_entity updatedUser = userRepo.save(user);
    	    updatedUser.setPassword(null);

    	    return ResponseEntity.ok(updatedUser);
    	}


}
