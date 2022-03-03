import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class E04_EmployeesWithSalaryOver50000 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        List<String> fromEmployees = entityManager.createQuery("SELECT e.firstName FROM Employee e" +
                " WHERE e.salary > 50000", String.class)
                .getResultList();

        fromEmployees.forEach(System.out::println);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
