package springdataadvancedquering.springdataadvancedquering.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springdataadvancedquering.springdataadvancedquering.entities.Shampoo;
import springdataadvancedquering.springdataadvancedquering.entities.Size;
import springdataadvancedquering.springdataadvancedquering.repositories.ShampooRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class ShampooServiceImpl implements ShampooService {
    private final ShampooRepository shampooRepository;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> selectBySize(Size size) {
        return this.shampooRepository.findBySize(size);
    }

    @Override
    public List<Shampoo> selectBySizeOrLabelId(Size size, long labelId) {
        return this.shampooRepository.findBySizeOrLabelIdOrderByPriceAsc(size, labelId);
    }

    @Override
    public List<Shampoo> selectMoreExpensiveThan(BigDecimal price) {
        return this.shampooRepository.findByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public Integer selectCountByPrice(BigDecimal price) {
        return this.shampooRepository.countByPriceLessThan(price);
    }

    @Override
    public List<Shampoo> findByIngredientsNames(Set<String> names) {
        return this.shampooRepository.findByIngredientsNames(names);
    }

    @Override
    public List<Shampoo> selectByIngredientCount(int count) {
        return this.shampooRepository.findByIngredientsCountLessThan(count);
    }
}
