package com.example.jsonprocessing;

import com.example.jsonprocessing.entities.categories.CategoryStats;
import com.example.jsonprocessing.entities.products.ProductWithoutBuyerDTO;
import com.example.jsonprocessing.entities.users.UserWithSoldProductsDTO;
import com.example.jsonprocessing.services.ProductService;
import com.example.jsonprocessing.services.SeedService;
import com.example.jsonprocessing.services.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductsShopRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final ProductService productService;
    private final UserService userService;

    private Gson gson;

    @Autowired
    public ProductsShopRunner(SeedService seedService, ProductService productService, UserService userService) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;

        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    @Override
    public void run(String... args) throws Exception {
//        this.seedService.seedAll();

//        productsBetweenPriceWithoutBuyer();

//        getUsersWithSoldProducts();

        List<CategoryStats> categoryStatistics = this.productService.getCategoryStatistics();
        String json = gson.toJson(categoryStatistics);
        System.out.println(json);
    }

    private void getUsersWithSoldProducts() {
        List<UserWithSoldProductsDTO> userWithSoldProducts = this.userService.getAllWithSoldProducts();
        String json = this.gson.toJson(userWithSoldProducts);
        System.out.println(json);
    }

    private void productsBetweenPriceWithoutBuyer() {
        List<ProductWithoutBuyerDTO> productsForSale = this.productService
                .getProductsInPriceRangeForSale(500, 1500);

        String json = this.gson.toJson(productsForSale);
        System.out.println(json);
    }
}
