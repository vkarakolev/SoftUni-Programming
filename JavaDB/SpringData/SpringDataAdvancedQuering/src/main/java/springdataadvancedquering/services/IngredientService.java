package springdataadvancedquering.springdataadvancedquering.services;

import springdataadvancedquering.springdataadvancedquering.entities.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> selectByNameStartsWith(String start);

    List<Ingredient> selectByNames(List<String> names);

    int deleteByName(String name);

    void increasePriceByPercentage(double percent);

    void updatePriceByNames(List<String> names, double percent);
}
