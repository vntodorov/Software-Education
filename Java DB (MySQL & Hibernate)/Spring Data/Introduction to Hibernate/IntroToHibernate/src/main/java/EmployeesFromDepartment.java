import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeesFromDepartment {

    private static final String GET_ALL_EMPLOYEES_IN_RESEARCH_DEPARTMENT = "SELECT e FROM Employee e WHERE e.department.name = :dp ORDER BY salary, id";

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String searchedDepartment = "Research and Development";

        entityManager.createQuery(GET_ALL_EMPLOYEES_IN_RESEARCH_DEPARTMENT, Employee.class)
                .setParameter("dp", searchedDepartment)
                .getResultList()
                .forEach(e -> System.out.printf("%s %s from %s - $%.2f%n", e.getFirstName(), e.getLastName(), e.getDepartment().getName(), e.getSalary()));

        entityManager.close();


    }
}
