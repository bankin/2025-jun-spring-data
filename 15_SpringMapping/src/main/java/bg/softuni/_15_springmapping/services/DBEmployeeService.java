package bg.softuni._15_springmapping.services;

import bg.softuni._15_springmapping.DBEmployee;
import bg.softuni._15_springmapping.dtos.DBEmployeeDTO;
import bg.softuni._15_springmapping.dtos.DBEmployeeInterfaceProjDTO;
import bg.softuni._15_springmapping.dtos.DBEmployeeProjDTO;
import bg.softuni._15_springmapping.repositories.DBEmployeeRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class DBEmployeeService {

    private final DBEmployeeRepository repository;
    private final ModelMapper mapper;

    public DBEmployeeService(DBEmployeeRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void create() {
        DBEmployee byId = this.repository.findById(1L).get();
        DBEmployee dbEmployee = new DBEmployee("Team", "Game", BigDecimal.TEN, byId);

        this.repository.save(dbEmployee);
    }

    @Transactional
    public List<DBEmployeeDTO> search(int bornAfterYear) {
        List<DBEmployee> all = this.repository.findBySalaryLessThan(BigDecimal.valueOf(8));

        DBEmployeeDTO[] result = this.mapper.map(all, DBEmployeeDTO[].class);

        return Arrays.asList(result);
    }

    public DBEmployeeProjDTO findProjection() {
        return this.repository.findSecond();
    }
}
