import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ChangeCasing {

    private static final String UPDATE_ALL_TOWNS_WITH_LENGTH_NAME_MORE_THAN_5 = "UPDATE Town t SET t.name = UPPER(t.name) WHERE LENGTH(t.name) > 5";
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Query towns = entityManager.createQuery(UPDATE_ALL_TOWNS_WITH_LENGTH_NAME_MORE_THAN_5, Town.class);

        List<Town> resultList = towns.getResultList();

        entityManager.persist(resultList);

        entityManager.getTransaction().commit();
        entityManager.close();



    }
}
