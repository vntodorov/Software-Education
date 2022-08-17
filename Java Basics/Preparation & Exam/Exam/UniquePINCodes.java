package EXAM;

import java.util.Scanner;

public class UniquePINCodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int upFirst = Integer.parseInt(scanner.nextLine());
        int upSecond = Integer.parseInt(scanner.nextLine());
        int upThird = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= upFirst ; i++) {
            for (int j = 2; j <= upSecond ; j++) {
                if (j > 7){
                    break;
                }
                for (int k = 1; k <= upThird ; k++) {
                    if ((i % 2 == 0 && k % 2 == 0) && (j == 2 || j % 2 != 0)){
                        System.out.printf("%d %d %d%n", i,j,k);
                    }
                }
            }
        }
    }
}
