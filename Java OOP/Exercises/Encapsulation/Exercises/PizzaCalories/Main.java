package EncapsulationEXERCISES.PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pizza pizza;
        Dough dough;

        String[] pizzaData = scanner.nextLine().split("\\s+");

        try {
            pizza = new Pizza(pizzaData[1], Integer.parseInt(pizzaData[2]));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String[] doughData = scanner.nextLine().split("\\s+");

        try {
            dough = new Dough(doughData[1], doughData[2], Double.parseDouble(doughData[3]));
            pizza.setDough(dough);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String command = scanner.nextLine();
        while (!command.equals("END")){
            String[] toppingData = command.split("\\s+");
            String toppingType = toppingData[1];
            double weight = Double.parseDouble(toppingData[2]);

            try {
                pizza.addTopping(new Topping(toppingType, weight));
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }

            command = scanner.nextLine();
        }

        System.out.println(pizza);

    }
}
