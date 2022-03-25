package springdataadvancedquering.springdataadvancedquering.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springdataadvancedquering.springdataadvancedquering.entities.Ingredient;
import springdataadvancedquering.springdataadvancedquering.repositories.IngredientRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> selectByNameStartsWith(String start) {
        return this.ingredientRepository.findByNameStartingWith(start);
    }

    @Override
    public List<Ingredient> selectByNames(List<String> names) {
        return this.ingredientRepository.findByNameInOrderByPriceAsc(names);
    }

    @Override
    @Transactional
    public int deleteByName(String name) {
        return this.ingredientRepository.deleteByName(name);
    }

    @Override
    @Transactional
    public void increasePriceByPercentage(double percent) {
        BigDecimal actualPercent = BigDecimal.valueOf(percent);
        this.ingredientRepository.increasePriceByPercent(actualPercent);
    }

    @Override
    @Transactional
    public void updatePriceByNames(List<String> names, double percent) {
        BigDecimal actualPercent = BigDecimal.valueOf(percent);
        this.ingredientRepository.updatePriceByNames(names, actualPercent);
    }
}
