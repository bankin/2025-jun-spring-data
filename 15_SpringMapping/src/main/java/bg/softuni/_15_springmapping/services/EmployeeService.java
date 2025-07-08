package bg.softuni._15_springmapping.services;

import bg.softuni._15_springmapping.dtos.EmployeeDTO;
import bg.softuni._15_springmapping.entities.Address;
import bg.softuni._15_springmapping.entities.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    private final ModelMapper mapper;

    public EmployeeService(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public EmployeeDTO findOne() {
        // repo.find...
        Address address = new Address("Bg", "Ruse");
        Employee employee = new Employee(
                "Pesho",
                "Goshov",
                BigDecimal.TEN,
                address,
                false,
                null,
                new ArrayList<>(),
                LocalDate.now());

        return this.mapper.map(employee, EmployeeDTO.class);
    }

    public List<EmployeeDTO> findAll() {
        Address address = new Address("Bg", "Ruse");

        List<Employee> dbAll = new ArrayList<>();
        dbAll.add(new Employee("Pesho", "Goshov", BigDecimal.TEN, address));
        dbAll.add(new Employee("Pesho2", "Goshov4", BigDecimal.ONE, address));
        dbAll.add(new Employee("Pesho3", "Goshov5", BigDecimal.ZERO, address));

        EmployeeDTO[] map = this.mapper.map(dbAll, EmployeeDTO[].class);

        return Arrays.asList(map);
    }
}
