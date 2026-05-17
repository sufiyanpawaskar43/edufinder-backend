package com.example.Edufinder.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Edufinder.entity.Favorite_Entity;
import com.example.Edufinder.repo.FavoriteRepository;



@Service
public class Favorite_Service {

    @Autowired
    private FavoriteRepository favoriteRepository;

    // ADD favorite
    public Favorite_Entity addFavorite(Favorite_Entity favorite) {

    	Favorite_Entity existing = favoriteRepository
                .findByUserIdAndItemIdAndItemType(
                        favorite.getUserId(),
                        favorite.getItemId(),
                        favorite.getItemType()
                );

        if (existing != null) {
            return existing; // already exists
        }

        return favoriteRepository.save(favorite);
    }

    // REMOVE favorite
    @Transactional 
    public void removeFavorite(Integer userId, Integer itemId, String itemType) {
        favoriteRepository.deleteByUserIdAndItemIdAndItemType(
                userId, itemId, itemType
        );
    }

    // GET all favorites of user
    public List<Favorite_Entity> getFavoritesByUser(Integer userId) {
        return favoriteRepository.findByUserId(userId);
    }
}
