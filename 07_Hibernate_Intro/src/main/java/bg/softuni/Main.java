package bg.softuni;

import bg.softuni.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure();

        SessionFactory factory = config.buildSessionFactory();
        Session currentSession = factory.openSession();
        currentSession.getTransaction().begin();

//        Student student = new Student();
//        student.setName("Pesho");
//
//        currentSession.persist(student);

        Student found = currentSession.find(Student.class, 1);
        System.out.println(found.getName());

        currentSession.getTransaction().commit();
        currentSession.close();
    }
}