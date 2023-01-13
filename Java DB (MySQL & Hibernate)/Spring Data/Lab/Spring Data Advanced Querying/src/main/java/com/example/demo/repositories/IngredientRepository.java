package com.example.demo.repositories;

import com.example.demo.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findByNameStartingWith(String letter);

    @Query("SELECT i FROM Ingredient AS i WHERE i.name IN :ingredients ORDER BY i.price")
    List<Ingredient> findByNameContaining(List<String> ingredients);

    void deleteByName(String name);

    @Query("UPDATE Ingredient AS i SET i.price = i.price * 1.10")
    @Modifying
    void updateAllPrice();

}
