package FirstStepsInCoding.lab;

import java.util.Scanner;

public class ProjectCreation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int number = Integer.parseInt(scanner.nextLine());
        int result = number * 3;
        System.out.printf("The architect %s will need %d hours to complete %d project/s.",name,result,number);



    }
}
