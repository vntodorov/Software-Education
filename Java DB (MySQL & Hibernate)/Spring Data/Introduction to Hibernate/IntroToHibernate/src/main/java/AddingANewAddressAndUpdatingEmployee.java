import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class AddingANewAddressAndUpdatingEmployee {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Address address = new Address();
        address.setText("Vitoshka 15");

        entityManager.getTransaction().begin();

        entityManager.persist(address);

        String lastName = new Scanner(System.in).nextLine();

        entityManager.createQuery("SELECT e FROM Employee e WHERE lastName = :dp", Employee.class)
                .setParameter("dp", lastName)
                .getResultList()
                .forEach(e -> e.setAddress(address));

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
