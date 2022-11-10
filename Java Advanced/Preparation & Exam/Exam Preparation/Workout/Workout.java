package ExamPreparation.Workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Workout {

    private List<Exercise> exercises;

    private String type;

    private int exerciseCount;

    public Workout(String type, int exerciseCount) {

        this.exercises = new ArrayList<>();
        this.type = type;
        this.exerciseCount = exerciseCount;

    }

    public void addExercise(Exercise exercise) {

        if (exercises.size() < exerciseCount) {
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                exercises.remove(exercise);
                return true;
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return exercise;
            }
        }
        return null;

    }

    public Exercise getMostBurnedCaloriesExercise() {
        if (exercises.isEmpty()) {
            return null;
        } else {
            return exercises.stream().sorted((f, s) -> Integer.compare(s.getBurnedCalories(), f.getBurnedCalories())).collect(Collectors.toList()).get(0);
        }
    }

    public int getExerciseCount() {
        return this.exerciseCount;
    }

    public String getStatistics() {
        StringBuilder statistic = new StringBuilder();
        statistic.append(String.format("Workout type: %s%n", this.type));
        exercises.forEach(e -> statistic.append(String.format("Exercise: %s, %s, %d%n", e.getName(), e.getMuscle(), e.getBurnedCalories())));
        return statistic.toString();
    }


}
