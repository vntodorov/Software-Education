package DataTypesAndVariablesEXERCISE;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte elevatePeople = Byte.parseByte(scanner.nextLine());
        byte elevatorCapacity = Byte.parseByte(scanner.nextLine());
        int courses = (int) Math.ceil((double) elevatePeople/elevatorCapacity);
        System.out.println(courses);
    }
}
