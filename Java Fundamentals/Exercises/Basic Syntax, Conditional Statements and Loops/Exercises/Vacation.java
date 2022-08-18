package BasicSyntaxEXERCISE;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int NumPeople = Integer.parseInt(scanner.nextLine());
        String group = scanner.nextLine();
        String day = scanner.nextLine();
        double price = 0;
        double promotion = 0;
        switch (group){
            case "Students":
                if (day.equals("Friday")){
                    price = NumPeople * 8.45;
                } else if (day.equals("Saturday")){
                    price = NumPeople * 9.80;
                } else {
                    price = NumPeople * 10.46;
                }
                if (NumPeople >= 30){
                    price -= price * 15 / 100;
                }
                break;
            case "Business":
                if (day.equals("Friday")){
                    price = NumPeople * 10.90;
                    promotion = 10 * 10.90;
                } else if (day.equals("Saturday")){
                    price = NumPeople * 15.60;
                    promotion = 10 * 15.60;
                } else {
                    price = NumPeople * 16;
                    promotion = 10 * 16;
                }
                if (NumPeople >= 100){
                    price -= promotion;
                }
                break;
            case "Regular":
                if (day.equals("Friday")){
                    price = NumPeople * 15;
                } else if (day.equals("Saturday")){
                    price = NumPeople * 20;
                } else {
                    price = NumPeople * 22.50;
                }
                if (NumPeople >= 10 && NumPeople <= 20){
                    price -= price * 5 / 100;
                }
                break;
        }
        System.out.printf("Total price: %.2f", price);
    }
}
