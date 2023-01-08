import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddressesWithEmployeeCount {

    private static final String GET_FIRST_10_ADDRESSES_ORDERED_BY_EMPLOYEES_LIVING = "SELECT a FROM Address a ORDER BY size(a.employees) DESC";

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.createQuery(GET_FIRST_10_ADDRESSES_ORDERED_BY_EMPLOYEES_LIVING, Address.class)
                .setMaxResults(10)
                .getResultList()
                .forEach(a -> System.out.printf("%s, %s - %d employees%n", a.getText(), a.getTown().getName(), a.getEmployees().size()));

        entityManager.close();


    }
}
