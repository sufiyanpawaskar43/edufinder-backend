package com.example.Edufinder.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Edufinder.entity.Favorite_Entity;

public interface FavoriteRepository extends JpaRepository<Favorite_Entity, Integer> {

    List<Favorite_Entity> findByUserId(Integer userId);

    Favorite_Entity findByUserIdAndItemIdAndItemType(
        Integer userId,
        Integer itemId,
        String itemType
    );

    void deleteByUserIdAndItemIdAndItemType(
        Integer userId,
        Integer itemId,
        String itemType
    );
}
