package bg.softuni.entities;

import bg.softuni.orm.annotations.Column;
import bg.softuni.orm.annotations.Entity;
import bg.softuni.orm.annotations.Id;

import java.time.LocalDate;

@Entity(name = "users")
public class User {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "age")
    private int age;

    @Column(name = "registration")
    private LocalDate registration;

    public User() {}

    public User(String username, int age, LocalDate registration) {
        this.username = username;
        this.age = age;
        this.registration = registration;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getRegistration() {
        return registration;
    }

    public void setRegistration(LocalDate registration) {
        this.registration = registration;
    }
}
