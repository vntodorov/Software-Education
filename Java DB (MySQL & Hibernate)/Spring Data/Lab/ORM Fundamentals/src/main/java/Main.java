import entities.Bike;
import entities.Car;
import entities.Plane;
import entities.Vehicle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("relations");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Vehicle car = new Car("Ford Focus", "Petrol", 5);
        Vehicle bike = new Bike();
        Vehicle plane = new Plane("Airbus", "Petrol", 200);

        entityManager.persist(car);
        entityManager.persist(bike);
        entityManager.persist(plane);

        Car fromDB = entityManager.find(Car.class, 1L);
        System.out.println(fromDB.getModel() + " " + fromDB.getSeats());




        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
