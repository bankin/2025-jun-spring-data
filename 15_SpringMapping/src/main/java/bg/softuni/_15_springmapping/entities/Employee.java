package bg.softuni._15_springmapping.entities;

import bg.softuni._15_springmapping.services.EmployeeService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//@Entity
public class Employee {
    private long id;
    private String firstname;
    private String lastname;
    private BigDecimal salary;
    private Address address;
    private boolean isOnHoliday;
    private Employee manager;
    private List<Employee> team;
    private LocalDate birthday;

    public Employee() {}

    public Employee(String firstname, String lastname, BigDecimal salary, Address address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
        this.address = address;
    }

    public Employee(String firstname, String lastname, BigDecimal salary, Address address, boolean isOnHoliday, Employee manager, List<Employee> team, LocalDate birthday) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
        this.address = address;
        this.isOnHoliday = isOnHoliday;
        this.manager = manager;
        this.team = team;
        this.birthday = birthday;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isOnHoliday() {
        return isOnHoliday;
    }

    public void setOnHoliday(boolean onHoliday) {
        isOnHoliday = onHoliday;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public List<Employee> getTeam() {
        return team;
    }

    public void setTeam(List<Employee> team) {
        this.team = team;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
