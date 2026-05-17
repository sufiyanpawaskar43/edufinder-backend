package com.example.Edufinder.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Edufinder.entity.Course_entity;
import com.example.Edufinder.entity.Institute_entity;
import com.example.Edufinder.repo.Course_repo;
import com.example.Edufinder.repo.Institute_repo;

@Service
public class Course_Service {

    @Autowired
    private Course_repo courseRepo;

    @Autowired
    private Institute_repo instituteRepo;

    public List<Course_entity> getAll() {
        return courseRepo.findAll();
    }
    
    // GET BY ID (DETAIL PAGE)
    public Optional<Course_entity> getById(Integer id) {
        return courseRepo.findById(id);
    }
    

    public Course_entity add(Integer instituteId, Course_entity c) {
        Institute_entity i = instituteRepo.findById(instituteId).orElse(null);
        if (i == null) return null;

        c.setInstitute(i);
        return courseRepo.save(c);
    }

    public boolean delete(Integer id) {
        if (!courseRepo.existsById(id)) return false;
        courseRepo.deleteById(id);
        return true;
    }

    public List<Course_entity> getByInstitute(Integer instituteId) {
        return courseRepo.findByInstituteId(instituteId);
    }
    
    public Course_entity update(Integer id, Course_entity c) {

        Optional<Course_entity> existingOpt = courseRepo.findById(id);

        if (existingOpt.isEmpty()) {
            return null;
        }

        Course_entity existing = existingOpt.get();

        // update allowed fields
        existing.setName(c.getName());
        existing.setDuration(c.getDuration());
        existing.setFees(c.getFees());
        existing.setLevel(c.getLevel());
        existing.setImage(c.getImage());
        existing.setRating(c.getRating());
        existing.setDescription(c.getDescription());

        return courseRepo.save(existing);
    }

}
