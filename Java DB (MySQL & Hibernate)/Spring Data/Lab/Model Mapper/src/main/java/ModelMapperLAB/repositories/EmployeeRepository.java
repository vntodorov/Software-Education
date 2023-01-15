package ModelMapperLAB.repositories;

import ModelMapperLAB.entities.DTOs.EmployeeDTO;
import ModelMapperLAB.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
