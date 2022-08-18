package ListEXERCISE;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> pokemonList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int sumOfRemovedElements = 0;
        while (pokemonList.size() != 0){
            int index = Integer.parseInt(scanner.nextLine());
            int removedElement = 0;
            if (index < 0){
                int lastElement = pokemonList.get(pokemonList.size() - 1);
                removedElement = pokemonList.get(0);
                pokemonList.remove(0);
                pokemonList.add(0, lastElement);
            } else if (index > pokemonList.size() - 1) {
                int firstElement = pokemonList.get(0);
                removedElement = pokemonList.get(pokemonList.size() - 1);
                pokemonList.remove(pokemonList.size() - 1);
                pokemonList.add(firstElement);
            } else {
                removedElement = pokemonList.get(index);
                pokemonList.remove(index);
            }
            for (int i = 0; i < pokemonList.size() ; i++) {
                int currentElement = pokemonList.get(i);
                if (pokemonList.get(i) <= removedElement){
                    currentElement += removedElement;
                } else {
                    currentElement -= removedElement;
                }
                pokemonList.set(i, currentElement);
            }
            sumOfRemovedElements += removedElement;
        }
        System.out.println(sumOfRemovedElements);
    }
}
