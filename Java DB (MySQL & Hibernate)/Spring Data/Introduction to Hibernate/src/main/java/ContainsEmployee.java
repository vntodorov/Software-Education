import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class ContainsEmployee {

    private static final String GET_ALL_EMPLOYEE_NAMES = "SELECT CONCAT(firstName, ' ', lastName) FROM Employee";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = emFactory.createEntityManager();

        List<String> employeeNames = entityManager.createQuery(GET_ALL_EMPLOYEE_NAMES, String.class).getResultList();

        String nameToSearch = scanner.nextLine();

        if (employeeNames.contains(nameToSearch)){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        entityManager.close();
    }
}
