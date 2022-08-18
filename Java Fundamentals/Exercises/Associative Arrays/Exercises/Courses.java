package MapsLambdaAndStreamApiEXERCISE;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> courses = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String course = command.split(" : ")[0];
            String student = command.split(" : ")[1];
            if (!courses.containsKey(course)) {
                courses.put(course, new ArrayList<>());
                courses.get(course).add(student);
            } else {
                courses.get(course).add(student);
            }
            command = scanner.nextLine();
        }
        courses.entrySet()
                .forEach(course -> {
                            System.out.printf("%s: %d%n", course.getKey(), course.getValue().size());
                            course.getValue().forEach(student -> System.out.printf("-- %s%n", student));

                        }
                );
    }
}
