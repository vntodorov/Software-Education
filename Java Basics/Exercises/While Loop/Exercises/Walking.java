package WhileLoop.exercises;

import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int goal = 10000;
        int AllSteps = 0;
        while (AllSteps < goal){
            String steps = scanner.nextLine();
            if (steps.equals("Going home")){
                int LastSteps = Integer.parseInt(scanner.nextLine());
                AllSteps += LastSteps;
                break;
            }
            int WalkedSteps = Integer.parseInt(steps);
            AllSteps += WalkedSteps;
        }
        int diff = Math.abs(AllSteps - goal);
        if (AllSteps >= goal){
            System.out.println("Goal reached! Good job!");
            System.out.printf("%d steps over the goal!", diff);
        } else {
            System.out.printf("%d more steps to reach goal.", diff);
        }
    }
}
