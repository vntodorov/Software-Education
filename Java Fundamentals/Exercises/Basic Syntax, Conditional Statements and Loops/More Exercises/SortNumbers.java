package BasicSyntax;

import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n1 = Double.parseDouble(scanner.nextLine());
        double n2 = Double.parseDouble(scanner.nextLine());
        double n3 = Double.parseDouble(scanner.nextLine());

        if (n1 <= n2 && n2 <= n3) {
            System.out.printf("%.0f\n%.0f\n%.0f", n3, n2, n1);
        } else if (n2 <= n3 && n3 <= n1) {
            System.out.printf("%.0f\n%.0f\n%.0f", n1, n3, n2);
        } else if (n3 <= n1 && n1 <= n2) {
            System.out.printf("%.0f\n%.0f\n%.0f", n2, n1, n3);
        } else if (n1 <= n3 && n3 <= n2) {
            System.out.printf("%.0f\n%.0f\n%.0f", n2, n3, n1);
        } else if (n2 <= n1 && n1 <= n3) {
            System.out.printf("%.0f\n%.0f\n%.0f", n3, n1, n2);
        } else if (n3 <= n2 && n2 <= n1) {
            System.out.printf("%.0f\n%.0f\n%.0f", n1, n2, n3);
        }

    }
}
