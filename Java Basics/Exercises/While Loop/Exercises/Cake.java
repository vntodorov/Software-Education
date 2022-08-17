package WhileLoop.exercises;

import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int CakeSize = width * length;
        String pieces = scanner.nextLine();
        int AllPieces = 0;
        while (!pieces.equals("STOP")){
            int NumPieces = Integer.parseInt(pieces);
            AllPieces += NumPieces;
            if (AllPieces > CakeSize){
                break;
            }
            pieces = scanner.nextLine();
        }
        int left = Math.abs(AllPieces - CakeSize);
        if (AllPieces <= CakeSize){
            System.out.printf("%d pieces are left.", left);
        } else {
            System.out.printf("No more cake left! You need %d pieces more.", left);
        }
    }
}
