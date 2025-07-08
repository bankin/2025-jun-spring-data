package bg.softuni._15_springmapping.dtos;

public class DBEmployeeDTO {
    private String firstname;
    private String lastname;

    private String managerFirstname;

    public DBEmployeeDTO() {}

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

    public String getManagerFirstname() {
        return managerFirstname;
    }

    public void setManagerFirstname(String managerFirstname) {
        this.managerFirstname = managerFirstname;
    }

    @Override
    public String toString() {
        return String.format("%s %s - [%s]",
            firstname, lastname, managerFirstname);
    }
}
