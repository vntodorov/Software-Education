import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class IncreaseSalaries {

    private static final String SELECT_NEEDED_EMPLOYEES = "SELECT e FROM Employee e WHERE e.department.name IN ('Engineering', 'Tool Design', 'Marketing', 'Information Services')";

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.createQuery(SELECT_NEEDED_EMPLOYEES, Employee.class)
                .getResultList()
                .forEach(e -> e.setSalary(e.getSalary().multiply(BigDecimal.valueOf(1.12))));

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
