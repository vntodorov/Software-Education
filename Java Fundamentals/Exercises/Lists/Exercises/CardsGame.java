package ListEXERCISE;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstPlayerList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondPlayerList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int firstCard = 0;
        int secondCard = 0;
        String winner = "";
        int sum = 0;
        for (int i = 0; i < firstPlayerList.size() ; i++) {
            if (firstPlayerList.get(i) > secondPlayerList.get(i)){
                firstCard = firstPlayerList.get(i);
                secondCard = secondPlayerList.get(i);
                firstPlayerList.add(firstCard);
                firstPlayerList.add(secondCard);
                firstPlayerList.remove(i);
                secondPlayerList.remove(i);
            } else if (firstPlayerList.get(i) < secondPlayerList.get(i)){
                firstCard = secondPlayerList.get(i);
                secondCard = firstPlayerList.get(i);
                secondPlayerList.add(firstCard);
                secondPlayerList.add(secondCard);
                secondPlayerList.remove(i);
                firstPlayerList.remove(i);
            } else {
                firstPlayerList.remove(i);
                secondPlayerList.remove(i);
            }
            if (firstPlayerList.size() == 0){
                for (int number : secondPlayerList){
                    sum += number;
                }
                winner = "Second";
                break;
            } else if (secondPlayerList.size() == 0) {
                for (int number : firstPlayerList){
                    sum += number;
                }
                winner = "First";
                break;
            }
            i = -1;
        }
        System.out.printf("%s player wins! Sum: %d", winner, sum);
    }
}
