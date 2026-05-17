package com.example.Edufinder.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Edufinder.entity.Institute_entity;
import com.example.Edufinder.repo.Institute_repo;

@Service
public class Institute_service {

    @Autowired
    private Institute_repo repo;

    public List<Institute_entity> getAll() {
        return repo.findAll();
    }

    public Optional<Institute_entity> getById(Integer id) {
        return repo.findById(id);
    }

    public Institute_entity add(Institute_entity i) {
        return repo.save(i);
    }

    public Institute_entity update(Integer id, Institute_entity i) {
        Institute_entity ex = repo.findById(id).orElse(null);
        if (ex == null) return null;

        ex.setName(i.getName());
        ex.setCity(i.getCity());
        ex.setState(i.getState());
        ex.setContact(i.getContact());
        ex.setEmail(i.getEmail());
        ex.setType(i.getType());
        ex.setRating(i.getRating());
        ex.setFees(i.getFees());
        ex.setDescription(i.getDescription());
        ex.setImage(i.getImage());

        return repo.save(ex);
    }

    public Institute_entity patch(Integer id, Institute_entity i) {
        Institute_entity ex = repo.findById(id).orElse(null);
        if (ex == null) return null;

        if (i.getName() != null) ex.setName(i.getName());
        if (i.getCity() != null) ex.setCity(i.getCity());
        if (i.getState() != null) ex.setState(i.getState());
        if (i.getContact() != null) ex.setContact(i.getContact());
        if (i.getEmail() != null) ex.setEmail(i.getEmail());
        if (i.getType() != null) ex.setType(i.getType());
        if (i.getFees()!= null) ex.setFees(i.getFees());
        if (i.getRating()!= null) ex.setRating(i.getRating());
        if (i.getDescription()!= null) ex.setDescription(i.getDescription());

        return repo.save(ex);
    }

    public boolean delete(Integer id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }
}
