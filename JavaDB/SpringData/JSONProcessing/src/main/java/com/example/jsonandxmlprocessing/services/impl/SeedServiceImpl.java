package com.example.jsonandxmlprocessing.services.impl;

import com.example.jsonandxmlprocessing.entities.categories.Category;
import com.example.jsonandxmlprocessing.entities.categories.CategoryImportDTO;
import com.example.jsonandxmlprocessing.entities.products.Product;
import com.example.jsonandxmlprocessing.entities.products.ProductImportDTO;
import com.example.jsonandxmlprocessing.entities.users.User;
import com.example.jsonandxmlprocessing.entities.users.UserImportDTO;
import com.example.jsonandxmlprocessing.repositories.CategoryRepository;
import com.example.jsonandxmlprocessing.repositories.ProductRepository;
import com.example.jsonandxmlprocessing.repositories.UserRepository;
import com.example.jsonandxmlprocessing.services.SeedService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SeedServiceImpl implements SeedService {

    private static final String USER_JSON_PATH = "src/main/resources/productsShop/users.json";
    private static final String CATEGORY_JSON_PATH = "src/main/resources/productsShop/categories.json";
    private static final String PRODUCT_JSON_PATH = "src/main/resources/productsShop/products.json";

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    private final ModelMapper mapper;
    private final Gson gson;

    @Autowired
    public SeedServiceImpl(UserRepository userRepository,
                           CategoryRepository categoryRepository,
                           ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;

        this.mapper = new ModelMapper();
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    @Override
    public void seedUsers() throws FileNotFoundException {
        FileReader fileReader = new FileReader(USER_JSON_PATH);
        UserImportDTO[] userImportDTOS = this.gson.fromJson(fileReader, UserImportDTO[].class);

        List<User> users = Arrays.stream(userImportDTOS)
                .map(importDTO -> this.mapper.map(importDTO, User.class))
                .collect(Collectors.toList());

        this.userRepository.saveAll(users); 
    }


    @Override
    public void seedProducts() throws FileNotFoundException {
        FileReader fileReader = new FileReader(PRODUCT_JSON_PATH);
        ProductImportDTO[] productImportDTOS = this.gson.fromJson(fileReader, ProductImportDTO[].class);

        List<Product> products = Arrays.stream(productImportDTOS)
                .map(importDTO -> this.mapper.map(importDTO, Product.class))
                .map(this::setRandomSeller)
                .map(this::setRandomBuyer)
                .map(this::setRandomCategories)
                .collect(Collectors.toList());

        this.productRepository.saveAll(products);
    }

    private Product setRandomCategories(Product product) {
        Random random = new Random();
        long categoriesDbCount = categoryRepository.count();
        int count = random.nextInt((int)categoriesDbCount);

        Set<Category> categories = new HashSet<>();
        for (int i = 0; i < count; i++) {
            int randomId = random.nextInt((int)categoriesDbCount) + 1;

            Optional<Category> category = this.categoryRepository.findById(randomId);

            categories.add(category.get());
        }

        product.setCategories(categories);
        return product;
    }

    private Product setRandomBuyer(Product product) {
        if(product.getPrice().compareTo(BigDecimal.valueOf(1000)) > 0) {
            return product;
        }

        Optional<User> buyer = getRandomUser();

        product.setBuyer(buyer.get());

        return product;
    }

    private Product setRandomSeller(Product product) {
        Optional<User> seller = getRandomUser();

        product.setSeller(seller.get());

        return product;
    }

    private Optional<User> getRandomUser() {
        long usersCount = userRepository.count();
        int randomUserId = new Random().nextInt((int)usersCount ) + 1;
        Optional<User> user = this.userRepository.findById(randomUserId);

        return user;
    }

    @Override
    public void seedCategories() throws FileNotFoundException {
        FileReader fileReader = new FileReader(CATEGORY_JSON_PATH);
        CategoryImportDTO[] categoryImportDTOS = this.gson.fromJson(fileReader, CategoryImportDTO[].class);

        List<Category> categories = Arrays.stream(categoryImportDTOS)
                .map(importDTO -> this.mapper.map(importDTO, Category.class))
                .collect(Collectors.toList());

        this.categoryRepository.saveAll(categories);
    }
}
