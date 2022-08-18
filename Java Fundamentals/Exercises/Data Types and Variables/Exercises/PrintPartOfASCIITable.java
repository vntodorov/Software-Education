package DataTypesAndVariablesEXERCISE;

import java.util.Scanner;

public class PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte start = Byte.parseByte(scanner.nextLine());
        byte end = Byte.parseByte(scanner.nextLine());
        for (int i = start; i <= end; i++) {
            char symbol = (char) i;
            System.out.print(symbol + " ");
        }
    }
}
