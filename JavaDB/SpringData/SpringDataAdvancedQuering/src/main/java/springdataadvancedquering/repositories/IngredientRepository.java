package springdataadvancedquering.springdataadvancedquering.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springdataadvancedquering.springdataadvancedquering.entities.Ingredient;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByNameStartingWith(String start);

    List<Ingredient> findByNameInOrderByPriceAsc(List<String> names);

    int deleteByName(String name);

    @Modifying
    @Query("UPDATE Ingredient i SET i.price = i.price + i.price * :multiplier")
    void increasePriceByPercent(@Param("multiplier")BigDecimal percent);

    @Modifying
    @Query("UPDATE Ingredient i SET i.price = i.price + i.price * :percent" +
            " WHERE i.name IN :names")
    void updatePriceByNames(List<String> names, BigDecimal percent);
}
