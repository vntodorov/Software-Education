package StacksAndQueuesLAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> print = new ArrayDeque<>();

        while (!input.equals("print")){

            if (input.equals("cancel")){
                if (!print.isEmpty()){
                    System.out.println("Canceled " + print.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                print.offer(input);

            }
            input = scanner.nextLine();
        }

        for (String file : print){
            System.out.println(file);
        }
    }
}
