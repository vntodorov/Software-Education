package ModelMapperLAB;

import ModelMapperLAB.entities.Address;
import ModelMapperLAB.entities.DTOs.EmployeeDTO;
import ModelMapperLAB.entities.Employee;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ModelMapperMain implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        ModelMapper mapper = new ModelMapper();

        /*PropertyMap<Employee, EmployeeDTO> propertyMap = new PropertyMap<>() {
            @Override
            protected void configure() {
                map().setCity(source.getAddress().getCity());
            }
        };

        mapper.addMappings(propertyMap);*/

        TypeMap<Employee, EmployeeDTO> typeMap = mapper.createTypeMap(Employee.class, EmployeeDTO.class);
        typeMap.addMappings(mapping -> mapping.map(source -> source.getAddress().getCity(), EmployeeDTO::setAddressCity));

        Address address = new Address("Bulgaria", "Sofia");
        Employee employee = new Employee("First", "Last", BigDecimal.valueOf(1000), LocalDate.of(2000, 1, 1), address);

        EmployeeDTO employeeDTO = typeMap.map(employee);

        System.out.println(employeeDTO);
    }
}
