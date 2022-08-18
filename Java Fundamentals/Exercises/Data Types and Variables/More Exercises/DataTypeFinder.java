package DataTypes;

import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            int integer = 0;
            int floating = 0;
            boolean flotPoint = false;
            String type = "string"; // string

            if (input.length() == 1) {
                char current = input.charAt(0);
                if ((current >= 48 && current <= 57)) {
                    type = "integer"; // integer
                } else {
                    type = "character"; // char
                }
            } else {
                for (int i = 0; i < input.length(); i++) { // INTEGERS & FLOAT POINT NUMS
                    char current = input.charAt(i);
                    if (i == 0 && current == 45) {
                        integer++;
                    }
                    if ((current >= 48 && current <= 57) || current == 46) { // int
                        integer++;
                        if (current == 46) {
                            floating++;
                            flotPoint = true;
                        }
                    }
                }
            }
            if (integer == input.length()) {
                if (flotPoint && floating == 1) { //floating point
                    type = "floating point";
                } else if (floating > 1) {

                } else {
                    type = "integer"; // integer
                }
            }
            String checkBl = input.toLowerCase(); // boolean
            switch (checkBl) {
                case "true":
                case "false":
                    type = "boolean";
            }

            System.out.printf("%s is %s type%n", input, type);
            input = scanner.nextLine();
        }
    }
}

