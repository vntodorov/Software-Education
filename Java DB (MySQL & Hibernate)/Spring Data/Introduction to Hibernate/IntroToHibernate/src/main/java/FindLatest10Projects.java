import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class FindLatest10Projects {

    private static final String FIND_FIRST_10_RECENTLY_STARTED_PROJECTS = "SELECT p FROM Project p ORDER BY p.startDate DESC";

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.createQuery(FIND_FIRST_10_RECENTLY_STARTED_PROJECTS, Project.class)
                .setMaxResults(10)
                .getResultList().stream().sorted(Comparator.comparing(Project::getName))
                .forEach(p -> System.out.printf("Project name: %s%n   Project Description: %s%n   Project Start Date: %s%n   Project End Date: %s%n", p.getName(), p.getDescription(), p.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), p.getEndDate()));

        entityManager.close();


    }
}
