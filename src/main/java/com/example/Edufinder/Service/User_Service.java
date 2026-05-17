package com.example.Edufinder.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Edufinder.entity.User_entity;
import com.example.Edufinder.repo.User_repo;

@Service
public class User_Service {

    @Autowired
    private User_repo userRepo;

    @Autowired
    private Email_Service emailService;

    /* ===== IMAGE UPLOAD PATH ===== */
    private static final String UPLOAD_DIR =
            System.getProperty("user.dir")
            + File.separator + "uploads"
            + File.separator + "users"
            + File.separator;

    /* ================= ADD USER ================= */
    public void adduser(User_entity ue) {
        userRepo.save(ue);

        emailService.sendEmail(
                ue.getEmail(),
                "Welcome to EduFinder 🎓",
                "Hi " + ue.getName() + ",\n\nWelcome to EduFinder!"
        );
    }

    /* ================= GET USER BY ID ================= */
    public User_entity getUserById(int id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    /* ================= SAVE USER ================= */
    public User_entity save(User_entity user) {
        return userRepo.save(user);
    }

    /* ================= UPDATE PROFILE ================= */
    public User_entity updateUser(
            int id,
            String firstName,
            String lastName,
            String email,
            MultipartFile image
    ) {

        User_entity user = getUserById(id);

        user.setName(firstName + " " + lastName);
        user.setEmail(email);

        if (image != null && !image.isEmpty()) {
            String fileName = saveImage(image);
            user.setImage(fileName);
        }

        return userRepo.save(user);
    }

    /* ================= SAVE IMAGE ================= */
    private String saveImage(MultipartFile image) {
        try {
            File dir = new File(UPLOAD_DIR);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String fileName =
                    UUID.randomUUID() + "_" + image.getOriginalFilename();

            Path path = Paths.get(UPLOAD_DIR + fileName);

            Files.copy(
                    image.getInputStream(),
                    path,
                    StandardCopyOption.REPLACE_EXISTING
            );

            return fileName;

        } catch (IOException e) {
            throw new RuntimeException("Image upload failed");
        }
    }
}
