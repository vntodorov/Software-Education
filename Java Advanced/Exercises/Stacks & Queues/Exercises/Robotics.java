package StacksAndQueuesEXERCISES;

import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] robotsInput = scanner.nextLine().split("\\;");

        Map<String, Integer> robots = new LinkedHashMap<>();

        for (String robot : robotsInput) {
            String robotsName = robot.split("\\-")[0];
            int robotsProcessTime = Integer.parseInt(robot.split("\\-")[1]);
            robots.put(robotsName, robotsProcessTime);
        }

        Map<String, Integer> basicProcessTime = new LinkedHashMap<>(robots);

        String startingTime = scanner.nextLine();
        int hour = Integer.parseInt(startingTime.split("\\:")[0]);
        int minutes = Integer.parseInt(startingTime.split("\\:")[1]);
        int seconds = Integer.parseInt(startingTime.split("\\:")[2]);

        String product = scanner.nextLine();
        ArrayDeque<String> productsQueue = new ArrayDeque<>();

        while (!product.equals("End")) {
            productsQueue.offer(product);
            product = scanner.nextLine();
        }

        while (!productsQueue.isEmpty()) {
            String currentProduct = productsQueue.peek();
            boolean isTaken = false;
            seconds++;

            if (seconds == 60) {
                minutes++;
                seconds = 0;
                if (minutes == 60) {
                    hour++;
                    minutes = 0;
                    if (hour == 24){
                        hour = 0;
                    }
                }
            }

            for (Map.Entry<String, Integer> robot : robots.entrySet()) {
                if (robot.getValue() < basicProcessTime.get(robot.getKey()) && robot.getValue() >= 0){
                    int remaining = robot.getValue() - 1;
                    robots.put(robot.getKey(), remaining);
                }
            }


            for (Map.Entry<String, Integer> robot : robots.entrySet()) {
                if (robot.getValue() == basicProcessTime.get(robot.getKey()) || robot.getValue() == - 1){
                    int remaining = basicProcessTime.get(robot.getKey()) - 1;
                    robots.put(robot.getKey(), remaining);
                    productsQueue.poll();
                    System.out.printf("%s - %s [%02d:%02d:%02d]%n", robot.getKey(), currentProduct, hour, minutes, seconds);
                    isTaken = true;
                    break;
                }
            }

            if (!isTaken){
                productsQueue.offer(productsQueue.poll());
            }


        }

    }
}