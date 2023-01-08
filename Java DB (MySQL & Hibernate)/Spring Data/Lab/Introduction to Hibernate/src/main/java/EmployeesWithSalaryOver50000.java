import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeesWithSalaryOver50000 {

    private static final String GET_FIRST_NAME_OF_EMPLOYEES_SALARY_OVER_50000 = "SELECT firstName FROM Employee WHERE salary > 50000";
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<String> allNeededEmployees = entityManager.createQuery(GET_FIRST_NAME_OF_EMPLOYEES_SALARY_OVER_50000, String.class).getResultList();

        for (String employee : allNeededEmployees) {
            System.out.println(employee);
        }

        entityManager.close();

    }
}
