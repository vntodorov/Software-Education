package ExceptionsAndErrorHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class EnterNumbers {

    public static void main(String[] args) {
        readNumber(1, 100);
    }

    public static void readNumber(int start, int end) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = new ArrayList<>();

        while (numbers.size() < 10){

            Optional<Integer> number;

            try{
                number = Optional.of(Integer.parseInt(scanner.nextLine()));
            } catch (Exception e){
                System.out.println("Invalid Number!");
                continue;
            }

            if (number.get() > start && number.get() < end){
                numbers.add(String.valueOf(number.get()));
                start = number.get();
            } else {
                System.out.println("Your number is not in range " + start + " - " + end + "!");
            }
        }

        System.out.println(String.join(", ", numbers));

    }
}
