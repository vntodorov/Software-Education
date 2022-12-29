import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class FindEmployeesByFirstName {

    private static final String GET_ALL_EMPLOYEES_WITH_START_OF_THE_NAME = "SELECT e FROM Employee e WHERE e.firstName LIKE :dp";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String startOfNamePattern = scanner.nextLine();

        entityManager.createQuery(GET_ALL_EMPLOYEES_WITH_START_OF_THE_NAME, Employee.class)
                .setParameter("dp", startOfNamePattern + "%")
                .getResultList()
                .forEach(e -> System.out.printf("%s %s - %s - ($%.2f)%n", e.getFirstName(), e.getLastName(), e.getJobTitle(), e.getSalary()));


    }
}
