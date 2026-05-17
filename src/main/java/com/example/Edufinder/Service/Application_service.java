package com.example.Edufinder.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Edufinder.entity.Application_entity;
import com.example.Edufinder.repo.Application_repo;

@Service
public class Application_service {

    @Autowired
    
    private Application_repo repo;

    @Autowired
    private Email_Service emailService; // Step 5

    public Application_entity apply(Application_entity app) {
        Application_entity saved = repo.save(app);

        // send email after save
        emailService.sendApplicationConfirmation(
            app.getEmail(), 
            app.getItemName()
        );

        return saved;
    }

    public List<Application_entity> getAll() {
        return repo.findAll();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public Application_entity updateStatus(int id, String status) {

        Application_entity app = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Application not found"));

        app.setStatus(status);
        Application_entity updated = repo.save(app);

        // email on status change
        emailService.sendStatusUpdateEmail(
            app.getEmail(),
            app.getItemName(),
            status
        );

        return updated;
    }

}
