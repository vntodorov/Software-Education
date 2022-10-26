package DefiningClassesEXERCISES.CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;

    private List<Employee> departmentEmployees;

    //private double averageSalary = departmentEmployees.stream().mapToDouble(Employee::getSalary).average().getAsDouble();


    public Department(String name){
        this.name = name;
        this.departmentEmployees = new ArrayList<>();


    }

    public double calculateAverageSalary(){
        return this.departmentEmployees.stream().mapToDouble(Employee::getSalary).average().orElse(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getDepartmentEmployees() {
        return departmentEmployees;
    }

    public void setDepartmentEmployees(List<Employee> departmentEmployees) {
        this.departmentEmployees = departmentEmployees;
    }
}
