package entities;

import java.math.BigDecimal;

//@Entity
public class Employee {
    private long id;

    private String firstname;

    private BigDecimal salary;

    // @OneToOne, @ManyToOne
    private Address address;

    public Employee() {
    }

    public Employee(String firstname, BigDecimal salary, Address address) {
        this.firstname = firstname;
        this.salary = salary;
        this.address = address;
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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
