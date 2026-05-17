package com.example.Edufinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Edufinder.Service.Favorite_Service;
import com.example.Edufinder.entity.Favorite_Entity;



@RestController
@RequestMapping("/favorites")
@CrossOrigin("*")
public class Favorite_Controller {

    @Autowired
    private Favorite_Service favoriteService;

    // ✅ ADD favorite
    @PostMapping("/add")
    public ResponseEntity<?> addFavorite(@RequestBody Favorite_Entity favorite) {
        return ResponseEntity.ok(favoriteService.addFavorite(favorite));
    }

    // ❌ REMOVE favorite
    @DeleteMapping("/remove")
    public ResponseEntity<?> removeFavorite(
            @RequestParam Integer userId,
            @RequestParam Integer itemId,
            @RequestParam String itemType
    ) {
        favoriteService.removeFavorite(userId, itemId, itemType);
        return ResponseEntity.ok("Removed from favorites");
    }

    // 📄 GET user's favorites
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Favorite_Entity>> getUserFavorites(
            @PathVariable Integer userId
    ) {
        return ResponseEntity.ok(
                favoriteService.getFavoritesByUser(userId)
        );
    }
}
