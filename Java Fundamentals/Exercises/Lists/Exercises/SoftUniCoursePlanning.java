package ListEXERCISE;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> lessonsList = Arrays.stream((scanner.nextLine().split(", "))).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("course start")) {
            String[] commandLines = command.split(":");
            String currentCommand = commandLines[0];
            String lessonTitle = commandLines[1];
            String lessonWithExercise = lessonTitle + "-Exercise";
            switch (currentCommand) {
                case "Add":
                    if (!lessonsList.contains(lessonTitle)) {
                        lessonsList.add(lessonTitle);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(commandLines[2]);
                    if (!lessonsList.contains(lessonTitle)) {
                        lessonsList.add(index, lessonTitle);
                    }
                    break;
                case "Remove":
                    lessonsList.remove(lessonTitle);
                    lessonsList.remove(lessonWithExercise);
                    break;
                case "Swap":
                    String secondLessonTitle = commandLines[2];
                    String secondLessonWithExercise = secondLessonTitle + "-Exercise";
                    if (lessonsList.contains(lessonTitle) && lessonsList.contains(secondLessonTitle)) {
                        int indexOfFirst = lessonsList.indexOf(lessonTitle);
                        int indexOfSecond = lessonsList.indexOf(secondLessonTitle);
                        lessonsList.set(indexOfFirst, secondLessonTitle);
                        lessonsList.set(indexOfSecond, lessonTitle);
                        if (lessonsList.contains(lessonWithExercise)) {
                            lessonsList.remove(lessonWithExercise);
                            lessonsList.add(indexOfSecond + 1, lessonWithExercise);
                        }
                        if (lessonsList.contains(secondLessonWithExercise)) {
                            lessonsList.remove(secondLessonWithExercise);
                            lessonsList.add(indexOfFirst + 1, secondLessonWithExercise);
                        }
                    }
                    break;
                case "Exercise":
                    if (lessonsList.contains(lessonTitle) && !lessonsList.contains(lessonWithExercise)) {
                        int indexOfTitle = lessonsList.indexOf(lessonTitle);
                        lessonsList.add(indexOfTitle + 1, lessonWithExercise);
                    } else if (!lessonsList.contains(lessonTitle) && !lessonsList.contains(lessonWithExercise)){
                        lessonsList.add(lessonTitle);
                        lessonsList.add(lessonWithExercise);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        int position = 1;
        for (String lesson : lessonsList) {
            System.out.printf("%d.%s%n", position, lesson);
            position++;
        }
    }
}
