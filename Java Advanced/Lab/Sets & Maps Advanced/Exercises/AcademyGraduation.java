package SetsAndMapsAdvancedLAB;

import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());

        Map<String, Double> studentsInfo = new TreeMap<>();

        for (int i = 0; i < students; i++) {

            String name = scanner.nextLine();
            double[] grades = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            double sumGrades = 0;

            for (double grade : grades) {
                sumGrades += grade;
            }

            double averageGrade = sumGrades / grades.length;
            studentsInfo.put(name, averageGrade);


        }

        for (Map.Entry<String, Double> student : studentsInfo.entrySet()) {
            System.out.print(student.getKey() + " is graduated with " + student.getValue());
            System.out.println();
        }


    }
}

