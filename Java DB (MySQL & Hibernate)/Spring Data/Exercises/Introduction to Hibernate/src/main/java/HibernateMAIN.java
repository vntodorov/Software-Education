import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateMAIN {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();


        //Student example = new Student();
        //example.setName("Tosho");
        //session.persist(example);

        //Student fromDB = session.get(Student.class, 1);
        //System.out.println(fromDB.getId() + " " + fromDB.getName());

        List<Student> from_student = session.createQuery("FROM Student", Student.class).list();


        session.getTransaction().commit();
        session.close();
    }
}
