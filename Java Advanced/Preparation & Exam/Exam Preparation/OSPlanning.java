package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Scanner;

public class OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tasks = scanner.nextLine().split("\\,\\s");
        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();

        for (String task : tasks){
            tasksStack.push(Integer.parseInt(task));
        }

        String[] threads = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> threadsQueue = new ArrayDeque<>();

        for (String thread : threads){
            threadsQueue.offer(Integer.parseInt(thread));
        }

        int taskToKill = Integer.parseInt(scanner.nextLine());

        int killerThread = 0;

        while (true){

            int currentTask = tasksStack.peek();
            int currentThread = threadsQueue.peek();

            if (currentTask == taskToKill){
                killerThread = currentThread;
                break;
            }

            if (currentThread >= currentTask){
                tasksStack.pop();
                threadsQueue.poll();
            } else {
                threadsQueue.poll();
            }

        }
        System.out.println("Thread with value " + killerThread + " killed task " + taskToKill);
        threadsQueue.forEach(t -> System.out.print(t + " "));

    }
}
