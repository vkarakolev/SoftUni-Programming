package com.example.jsonandxmlprocessing;

import com.example.jsonandxmlprocessing.entities.categories.CategoryStatsDTO;
import com.example.jsonandxmlprocessing.entities.categories.XMLCategoryStatsDTO;
import com.example.jsonandxmlprocessing.entities.categories.XMLCategoryStatsList;
import com.example.jsonandxmlprocessing.entities.products.ProductWithoutBuyerDTO;
import com.example.jsonandxmlprocessing.entities.users.UserWithSoldProductsDTO;
import com.example.jsonandxmlprocessing.services.ProductService;
import com.example.jsonandxmlprocessing.services.SeedService;
import com.example.jsonandxmlprocessing.services.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.stream.Collectors;

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

//        getCategoryStats();

//        xmlMarshallDemo();

        xmlUnmarshallDemo();
    }

    private void xmlUnmarshallDemo() throws JAXBException {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "      <category>\n" +
                "         <name>Drugs</name>\n" +
                "         <product-count>73</product-count>\n" +
                "         <average-price>806.112877</average-price>\n" +
                "         <total-revenue>58846.24</total-revenue>\n" +
                "      </category>";

        JAXBContext context = JAXBContext.newInstance(XMLCategoryStatsDTO.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(xml.getBytes());
        XMLCategoryStatsDTO result = (XMLCategoryStatsDTO)unmarshaller.unmarshal(inputStream);
        System.out.println(result);
    }

    private void xmlMarshallDemo() throws JAXBException {
        List<XMLCategoryStatsDTO> xmlResult = this.productService.getCategoryStatistics()
                .stream()
                .map(XMLCategoryStatsDTO::new)
                .collect(Collectors.toList());

        XMLCategoryStatsList xmlCategoryStatsList = new XMLCategoryStatsList(xmlResult);

        JAXBContext context = JAXBContext.newInstance(XMLCategoryStatsList.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(xmlCategoryStatsList, System.out);
    }

    private void getCategoryStats() {
        List<CategoryStatsDTO> result = this.productService.getCategoryStatistics();
        String json = gson.toJson(result);
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
