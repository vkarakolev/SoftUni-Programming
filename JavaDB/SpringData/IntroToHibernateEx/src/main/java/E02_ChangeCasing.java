import entities.Town;

import javax.persistence.*;
import java.util.List;

public class E02_ChangeCasing {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Query from_town = entityManager.createQuery("SELECT t FROM Town t", Town.class);
        List<Town> townList = from_town.getResultList();

        for (Town town : townList) {
            String name = town.getName();

            if(name.length() <= 5) {
                String upperCase = name.toUpperCase();
                town.setName(upperCase);
            }

            entityManager.persist(town);
        }

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
