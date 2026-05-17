package com.example.Edufinder.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Edufinder.entity.College_entity;
import com.example.Edufinder.repo.College_repo;

@Service
public class College_Service {

    @Autowired
    private College_repo collegeRepo;

    public List<College_entity> getAllColleges() {
        return collegeRepo.findAll();
    }

    public Optional<College_entity> getById(Integer id) {
        return collegeRepo.findById(id);
    }

    public College_entity addCollege(College_entity college) {
        return collegeRepo.save(college);
    }

    public College_entity updateById(Integer id, College_entity c) {
        College_entity existing = collegeRepo.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setName(c.getName());
        existing.setCity(c.getCity());
        existing.setState(c.getState());
        existing.setType(c.getType());
        existing.setStream(c.getStream());
        existing.setFees(c.getFees());
        existing.setRating(c.getRating());
        existing.setDescription(c.getDescription());

        return collegeRepo.save(existing);
    }

    public College_entity patchById(Integer id, College_entity c) {
        College_entity existing = collegeRepo.findById(id).orElse(null);
        if (existing == null) return null;

        if (c.getName() != null) existing.setName(c.getName());
        if (c.getCity() != null) existing.setCity(c.getCity());
        if (c.getState() != null) existing.setState(c.getState());
        if (c.getType() != null) existing.setType(c.getType());
        if (c.getStream() != null) existing.setStream(c.getStream());
        if (c.getFees() != null) existing.setFees(c.getFees());
        if (c.getRating()!= null) existing.setRating(c.getRating());
        if (c.getDescription()!=null) existing.setDescription(c.getDescription());

        return collegeRepo.save(existing);
    }

    public boolean deleteById(Integer id) {
        if (!collegeRepo.existsById(id)) return false;
        collegeRepo.deleteById(id);
        return true;
    }

    public List<College_entity> getByCity(String city) {
        return collegeRepo.findByCity(city);
    }

    public List<College_entity> getByStream(String stream) {
        return collegeRepo.findByStream(stream);
    }
}
