package DefiningClassesEXERCISES.CompanyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        List<Department> allDepartments = new ArrayList<>();

        for (int i = 0; i < lines; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String employeeDepartment = data[3];

            Employee employee = new Employee(name, salary, position, employeeDepartment);

            switch (data.length) {
                case 5:
                    String ageOrEmail = data[4];
                    if (ageOrEmail.contains("@")) {
                        employee.setEmail(ageOrEmail);
                        employee.setAge(-1);
                    } else {
                        employee.setEmail("n/a");
                        employee.setAge(Integer.parseInt(ageOrEmail));
                    }
                    break;
                case 6:
                    String email = data[4];
                    int age = Integer.parseInt(data[5]);
                    employee.setEmail(email);
                    employee.setAge(age);
                    break;
            }

            boolean departmentExists = allDepartments.stream().anyMatch(department -> department.getName().equals(employeeDepartment));

            if (!departmentExists) {
                Department currentDepartment = new Department(employeeDepartment);
                allDepartments.add(currentDepartment);
            }

            Department currentDepartment = allDepartments.stream().filter(dep -> dep.getName().equals(employeeDepartment)).findFirst().get();

            currentDepartment.getDepartmentEmployees().add(employee);

        }

        Department highestPaidDepartment = allDepartments.stream().max(Comparator.comparingDouble(Department::calculateAverageSalary)).get();

        System.out.println("Highest Average Salary: " + highestPaidDepartment.getName());
        highestPaidDepartment.getDepartmentEmployees().stream()
                .sorted((first, second) -> Double.compare(second.getSalary(), first.getSalary()))
                .forEach(System.out::println);

    }
}
