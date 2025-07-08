package bg.softuni._15_springmapping;

import bg.softuni._15_springmapping.dtos.DBEmployeeDTO;
import bg.softuni._15_springmapping.dtos.DBEmployeeInterfaceProjDTO;
import bg.softuni._15_springmapping.dtos.DBEmployeeProjDTO;
import bg.softuni._15_springmapping.dtos.EmployeeDTO;
import bg.softuni._15_springmapping.services.DBEmployeeService;
import bg.softuni._15_springmapping.services.EmployeeService;
import bg.softuni._15_springmapping.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private final EmployeeService employeeService;
    private final ManagerService managerService;
    private final DBEmployeeService dbEmployeeService;

    @Autowired
    public Runner(EmployeeService employeeService, ManagerService managerService, DBEmployeeService dbEmployeeService) {
        this.employeeService = employeeService;
        this.managerService = managerService;
        this.dbEmployeeService = dbEmployeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Working...");

        EmployeeDTO one = this.employeeService.findOne();

        System.out.println(one);

        List<DBEmployeeDTO> search = dbEmployeeService.search(1990);

        System.out.println(search);

        DBEmployeeProjDTO projection = dbEmployeeService.findProjection();

        System.out.println(projection.getFirstname());
    }
}
