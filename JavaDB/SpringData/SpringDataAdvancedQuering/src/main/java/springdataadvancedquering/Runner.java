package springdataadvancedquering.springdataadvancedquering;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springdataadvancedquering.springdataadvancedquering.entities.Size;
import springdataadvancedquering.springdataadvancedquering.services.IngredientService;
import springdataadvancedquering.springdataadvancedquering.services.ShampooService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

@Component
public class Runner implements CommandLineRunner {
    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    @Autowired
    public Runner(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {

        //Ex.1
        this.shampooService.selectBySize(Size.MEDIUM)
                .forEach(System.out::println);

        //Ex.2
        this.shampooService.selectBySizeOrLabelId(Size.MEDIUM, 10)
                .forEach(System.out::println);
        //Ex.3
        this.shampooService.selectMoreExpensiveThan(BigDecimal.valueOf(5))
                .forEach(System.out::println);

        //Ex.4
        this.ingredientService.selectByNameStartsWith("M")
                .forEach(System.out::println);

        //Ex.5
        List<String> names = List.of("Lavender", "Herbs", "Apple");
        this.ingredientService.selectByNames(names)
                .forEach(System.out::println);

        //Ex.6
        int count = this.shampooService.selectCountByPrice(BigDecimal.valueOf(8.5));
        System.out.println(count);

        //Ex.7
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();

        Set<String> shampooNames = Set.of(first, second);

        this.shampooService.findByIngredientsNames(shampooNames)
                .forEach(System.out::println);

        //Ex.8
        this.shampooService.selectByIngredientCount(2)
                .forEach(System.out::println);

        //Ex.9
        System.out.println(this.ingredientService.deleteByName("Nettle"));

        //Ex.10
        this.ingredientService.increasePriceByPercentage(0.1);

        //Ex.11
        List<String> ingredientNames = List.of("Lavender", "Herbs", "Apple");
        this.ingredientService.updatePriceByNames(ingredientNames, 0.1);
    }
}
