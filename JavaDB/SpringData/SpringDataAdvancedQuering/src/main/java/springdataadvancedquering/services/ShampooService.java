package springdataadvancedquering.springdataadvancedquering.services;

import springdataadvancedquering.springdataadvancedquering.entities.Shampoo;
import springdataadvancedquering.springdataadvancedquering.entities.Size;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface ShampooService {
    List<Shampoo> selectBySize(Size size);

    List<Shampoo> selectBySizeOrLabelId(Size size, long labelId);

    List<Shampoo> selectMoreExpensiveThan(BigDecimal price);

    Integer selectCountByPrice(BigDecimal price);

    List<Shampoo> findByIngredientsNames(Set<String> names);

    List<Shampoo> selectByIngredientCount(int count);
}
