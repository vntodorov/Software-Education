package ModelMapperLAB.services;

import ModelMapperLAB.entities.DTOs.CreateEmployeeDTO;
import ModelMapperLAB.entities.DTOs.EmployeeDTO;
import ModelMapperLAB.entities.Employee;

import java.util.List;

public interface EmployeeService {

    Employee create(CreateEmployeeDTO employeeDTO);

    List<EmployeeDTO> findAll();
}
