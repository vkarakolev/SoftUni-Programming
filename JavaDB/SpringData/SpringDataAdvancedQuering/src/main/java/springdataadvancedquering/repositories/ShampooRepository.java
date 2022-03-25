package springdataadvancedquering.springdataadvancedquering.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springdataadvancedquering.springdataadvancedquering.entities.Shampoo;
import springdataadvancedquering.springdataadvancedquering.entities.Size;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findByBrand(String brand);

    List<Shampoo> findByBrandAndSize(String brand, Size size);

    List<Shampoo> findBySizeOrderById(Size size);

    List<Shampoo> findBySize(Size size);

    List<Shampoo> findBySizeOrLabelIdOrderByPriceAsc(Size size, long labelId);

    List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    Integer countByPriceLessThan(BigDecimal price);

    @Query("SELECT s FROM Shampoo s" +
            " JOIN s.ingredients AS i" +
            " WHERE i.name in :ingredientsNames")
    List<Shampoo> findByIngredientsNames(
            @Param("ingredientsNames")Set<String> names);

    @Query("SELECT s FROM Shampoo s" +
            " WHERE s.ingredients.size < :count")
    List<Shampoo> findByIngredientsCountLessThan(int count);
}
