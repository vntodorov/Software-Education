package ObjectsAndClassesLAB;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {

    static class Student {
        String firstName;
        String lastName;
        String age;
        String hometown;

        public Student(String firstName, String lastName, String age, String hometown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.hometown = hometown;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getAge() {
            return age;
        }

        public String getHometown() {
            return hometown;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Student> studentsList = new ArrayList<>();
        while (!input.equals("end")) {
            String[] studentsArray = input.split(" ");
            String firstName = studentsArray[0];
            String lastName = studentsArray[1];
            String age = studentsArray[2];
            String hometown = studentsArray[3];
            Student currentStudent = new Student(firstName, lastName, age, hometown);
            studentsList.add(currentStudent);
            input = scanner.nextLine();
        }
        String hometown = scanner.nextLine();
        for (Student name : studentsList){
            if (name.getHometown().equals(hometown)){
                System.out.printf("%s %s is %s years old%n", name.getFirstName(), name.getLastName(), name.getAge());
            }
        }
    }
}
