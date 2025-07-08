package bg.softuni._15_springmapping.dtos;

import java.util.List;
import java.util.stream.Collectors;

public class ManagerDTO {
    private String firstname;
    private String lastname;
    private List<EmployeeDTO> team;

    public ManagerDTO() {}

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

    public List<EmployeeDTO> getTeam() {
        return team;
    }

    public void setTeam(List<EmployeeDTO> team) {
        this.team = team;
    }

    @Override
    public String toString() {
        String teamStr = this.team
            .stream()
            .map(e -> String.format("- %s %s %.2f", e.getFirstname(), e.getLastname(), e.getSalary()))
            .collect(Collectors.joining("\n"));

        return String.format("%s %s | Employees : %d%n%s",
            firstname, lastname, this.team.size(), teamStr);
    }
}
