package MapsLambdaAndStreamApiEXERCISE;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> grades = new LinkedHashMap<>();
        int rows = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= rows ; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            if (!grades.containsKey(name)){
                grades.put(name, grade);
            } else {
                double newGrade = (grades.get(name) + grade) / 2;
                grades.put(name, newGrade);
            }
        }
        grades.entrySet().stream().filter(student -> student.getValue() >= 4.50)
                .forEach(student -> System.out.printf("%s -> %.2f%n", student.getKey(), student.getValue()));
    }
}
