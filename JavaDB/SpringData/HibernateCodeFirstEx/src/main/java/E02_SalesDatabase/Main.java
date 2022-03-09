package E02_SalesDatabase;

import E02_SalesDatabase.Entities.Customer;
import E02_SalesDatabase.Entities.Product;
import E02_SalesDatabase.Entities.Sale;
import E02_SalesDatabase.Entities.StoreLocation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateCodeFirst");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Product product = new Product("asd", 123, BigDecimal.TEN);
        Customer customer = new Customer("asd", "asd", "asd");
        StoreLocation storeLocation = new StoreLocation("asd");
        Sale sale = new Sale(product, customer, storeLocation);

        entityManager.persist(product);
        entityManager.persist(customer);
        entityManager.persist(storeLocation);
        entityManager.persist(sale);


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
