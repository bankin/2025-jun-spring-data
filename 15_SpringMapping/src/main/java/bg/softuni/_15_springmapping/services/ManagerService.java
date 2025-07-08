package bg.softuni._15_springmapping.services;

import bg.softuni._15_springmapping.dtos.ManagerDTO;
import bg.softuni._15_springmapping.entities.Address;
import bg.softuni._15_springmapping.entities.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerService {

    private final ModelMapper mapper;

    public ManagerService(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public ManagerDTO findCEO() {
        Address address = new Address("BG", "Burgas");

        List<Employee> dbTeam = new ArrayList<>();
        dbTeam.add(new Employee("Pesho", "Goshov", BigDecimal.TEN, address));
        dbTeam.add(new Employee("Pesho2", "Goshov4", BigDecimal.ONE, address));
        dbTeam.add(new Employee("Pesho3", "Goshov5", BigDecimal.ZERO, address));

        Employee ceo = new Employee(
                "Manager",
                "Manager LAst",
                BigDecimal.TEN,
                address,
                false,
                null,
                dbTeam,
                null
        );

        return mapper.map(ceo, ManagerDTO.class);
    }
}
