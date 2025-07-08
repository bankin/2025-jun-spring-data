package bg.softuni._15_springmapping.repositories;

import bg.softuni._15_springmapping.DBEmployee;
import bg.softuni._15_springmapping.dtos.DBEmployeeInterfaceProjDTO;
import bg.softuni._15_springmapping.dtos.DBEmployeeProjDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface DBEmployeeRepository extends JpaRepository<DBEmployee, Long> {

    List<DBEmployee> findBySalaryLessThan(BigDecimal salary);

    DBEmployeeInterfaceProjDTO findFirstBySalaryLessThan(BigDecimal salary);

    @Query("SELECT e FROM DBEmployee AS e WHERE e.salary < 10")
    DBEmployeeInterfaceProjDTO findFirst();

    @Query("SELECT new bg.softuni._15_springmapping.dtos.DBEmployeeProjDTO(e.firstname, e.lastname) FROM DBEmployee AS e WHERE e.salary < 10")
    DBEmployeeProjDTO findSecond();
}
