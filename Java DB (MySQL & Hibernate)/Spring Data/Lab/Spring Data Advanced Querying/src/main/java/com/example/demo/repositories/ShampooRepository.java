package com.example.demo.repositories;

import com.example.demo.entities.Shampoo;
import com.example.demo.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    List<Shampoo> findBySizeOrderById(Size size);

    @Query("SELECT s FROM Shampoo AS s Join s.ingredients AS i WHERE i.name = :name")
    List<Shampoo> findByIngredient(@Param("name") String ingredient);

    @Query("SELECT s FROM Shampoo AS s Join s.ingredients AS i WHERE i.name IN :ingredients")
    List<Shampoo> findByIngredients(List<String> ingredients);

    List<Shampoo> findBySizeOrLabelIdOrderByPrice(Size size, long labelId);

    List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    Long countByPriceLessThan(BigDecimal price);

    @Query("SELECT s FROM Shampoo AS s WHERE s.ingredients.size < :count")
    List<Shampoo> findByIngredientsCountLessThan(int count);


}
