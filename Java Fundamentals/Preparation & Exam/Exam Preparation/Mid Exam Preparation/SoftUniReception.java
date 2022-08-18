package MidExamEXERCISE;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int secondEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int thirdEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        int hoursCount = 0;
        while (studentsCount > 0){
            hoursCount++;
            if (hoursCount % 4 == 0){
                hoursCount++;
            }
            studentsCount -= firstEmployeeEfficiency + secondEmployeeEfficiency + thirdEmployeeEfficiency;
        }
        System.out.printf("Time needed: %dh.", hoursCount);
    }
}
