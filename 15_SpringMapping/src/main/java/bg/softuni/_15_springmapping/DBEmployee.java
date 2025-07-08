package bg.softuni._15_springmapping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "employees")
public class DBEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private BigDecimal salary;

    @ManyToOne(fetch = FetchType.LAZY)
    private DBEmployee manager;

    public DBEmployee() {}

    public DBEmployee(String firstname, String lastname, BigDecimal salary, DBEmployee manager) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
        this.manager = manager;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public DBEmployee getManager() {
        return manager;
    }

    public void setManager(DBEmployee manager) {
        this.manager = manager;
    }
}
