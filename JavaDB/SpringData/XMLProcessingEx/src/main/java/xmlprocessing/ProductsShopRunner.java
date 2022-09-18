package xmlprocessing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import xmlprocessing.services.SeedService;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

@Component
public class ProductsShopRunner implements CommandLineRunner {

    private final SeedService seedService;

    @Autowired
    public ProductsShopRunner(SeedService seedService) {
        this.seedService = seedService;
    }

    @Override
    public void run(String... args) throws JAXBException, FileNotFoundException {
        this.seedService.seedCategories();
    }

}