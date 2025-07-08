package dtos;

import entities.Employee;

public class EmployeeDTO {
    private long id;

    private String firstname;

    private String addressCity;

    public EmployeeDTO() {}

    public EmployeeDTO(long id, String firstname, String addressCity) {
        this.id = id;
        this.firstname = firstname;
        this.addressCity = addressCity;
    }

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.firstname = employee.getFirstname();
        this.addressCity = employee.getAddress().getCity();
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

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", addressCity='" + addressCity + '\'' +
                '}';
    }
}
