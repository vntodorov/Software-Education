import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.Scanner;

public class GetEmployeeWithProject {

    private static final String FIND_EMPLOYEE_BY_ID = "SELECT e FROM Employee e WHERE e.id = :idp";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        int idInput = Integer.parseInt(scanner.nextLine());

        Employee employee = entityManager.createQuery(FIND_EMPLOYEE_BY_ID, Employee.class).setParameter("idp", idInput).getSingleResult();

        System.out.printf("%s %s - %s%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle());

        employee.getProjects().stream().sorted(Comparator.comparing(Project::getName)).forEach(p -> System.out.printf("      %s%n", p.getName()));

    }
}
