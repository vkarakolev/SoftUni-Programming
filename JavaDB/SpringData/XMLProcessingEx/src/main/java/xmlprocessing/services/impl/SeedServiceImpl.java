package xmlprocessing.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmlprocessing.entities.categories.Category;
import xmlprocessing.entities.categories.CategoryImportDTO;
import xmlprocessing.entities.products.Product;
import xmlprocessing.entities.users.User;
import xmlprocessing.repositories.CategoryRepository;
import xmlprocessing.repositories.ProductRepository;
import xmlprocessing.repositories.UserRepository;
import xmlprocessing.services.SeedService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SeedServiceImpl implements SeedService {

    private static final String USER_XML_PATH = "src/main/resources/productsShop/users.xml";
    private static final String CATEGORY_XML_PATH = "src/main/resources/productsShop/categories.xml";
    private static final String PRODUCT_XML_PATH = "src/main/resources/productsShop/products.xml";

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public SeedServiceImpl(UserRepository userRepository,
                           CategoryRepository categoryRepository,
                           ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void seedUsers() throws FileNotFoundException {

    }

    @Override
    public void seedCategories() throws FileNotFoundException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(CategoryImportDTO.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        FileReader xmlReader = new FileReader(CATEGORY_XML_PATH);
        CategoryImportDTO importDTO = (CategoryImportDTO) unmarshaller.unmarshal(xmlReader);

        List<Category> entities = importDTO.getCategories()
                .stream()
                .map(cn -> new Category(cn.getName()))
                .collect(Collectors.toList());

        this.categoryRepository.saveAll(entities);
    }

    @Override
    public void seedProducts() throws FileNotFoundException {

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

}
