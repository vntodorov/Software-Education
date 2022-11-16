package WorkingWithAbstractionLAB.StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> students;

    public StudentSystem() {
        this.students = new HashMap<>();
    }

    public Map<String, Student> getStudents() {
        return this.students;
    }

    public void create(String[] studentData) {

        String name = studentData[1];
        int age = Integer.parseInt(studentData[2]);
        double grade = Double.parseDouble(studentData[3]);

        if (!students.containsKey(name)) {
            Student student = new Student(name, age, grade);
            this.students.put(name, student);
        }

    }

    public void show(String name) {

        StringBuilder view = new StringBuilder();

        if (students.containsKey(name)) {
            Student student = this.students.get(name);
            view.append(String.format("%s is %s years old.", student.getName(), student.getAge()));

            if (student.getGrade() >= 5.00) {
                view.append(" Excellent student.");
            } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                view.append(" Average student.");
            } else {
                view.append(" Very nice person.");
            }

        }

        System.out.println(view);
    }

}
