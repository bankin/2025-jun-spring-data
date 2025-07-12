import dtos.EmployeeDTO;
import entities.Address;
import entities.Employee;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
//        fromDbToPresentation();
//        fromPresentationToDb();

        ModelMapper mapper = new ModelMapper();

        Address address = new Address("Bg", "Plovdiv");
        Employee milena = new Employee("Milena", BigDecimal.TEN, address);

        EmployeeDTO result = mapper.map(milena, EmployeeDTO.class);

        PropertyMap<Employee, EmployeeDTO> customMap = new PropertyMap<>() {
            @Override
            protected void configure() {
//                using(upperCaseConverter).map().setFirstname(source.getFirstname());
                map().setId(source.getId());
                map().setFirstname(source.getFirstname());
                map().setAddressCity(source.getAddress().getCountry());
            }
        };

        mapper.addMappings(customMap);
        EmployeeDTO custom = mapper.map(milena, EmployeeDTO.class);

        ModelMapper second = new ModelMapper();
        EmployeeDTO secondResult = second.map(milena, EmployeeDTO.class);

        System.out.println(custom);
        System.out.println(secondResult);
    }

    private static void fromPresentationToDb() {
        EmployeeDTO inputData = new EmployeeDTO(10, "Pesho", "Sofia");

        Employee toInsert = new Employee();
        toInsert.setId(inputData.getId());
        toInsert.setFirstname(inputData.getFirstname());
        // Get address by city from db
//        toInsert.setAddress(???);

        // Wrong!!
//        Employee altInsert = new Employee(inputData);
    }

    private static void fromDbToPresentation() {
        Address address = new Address("BG", "Sofia");
        Employee employee = new Employee("Pesho", BigDecimal.TEN, address);

        EmployeeDTO dto = mapToDTO(employee);

        System.out.println(dto);
    }

    private static EmployeeDTO mapToDTO(Employee employee) {
        EmployeeDTO result = new EmployeeDTO();

        result.setId(employee.getId());
        result.setFirstname(employee.getFirstname());
        result.setAddressCity(employee.getAddress().getCity());

        // OK!!
        EmployeeDTO altResult = new EmployeeDTO(employee);

        return result;
    }
}
