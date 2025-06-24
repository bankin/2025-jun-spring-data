package bg.softuni;

import bg.softuni.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("my-emf");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        Student student = new Student();
        student.setName("Gosho2");

        entityManager.persist(student);

        Student found = entityManager.find(Student.class, 1);
        System.out.println(found.getName());

        entityManager.getTransaction().commit();
    }
}