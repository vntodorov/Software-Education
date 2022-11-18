package EncapsulationLAB.FirstAndReserveTeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> players = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] personData = scanner.nextLine().split("\\s+");
            try{
                players.add(new Person(personData[0], personData[1], Integer.parseInt(personData[2]), Double.parseDouble(personData[3])));
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        Team team = new Team("Black Eagles");

        for (Person player : players){
            team.addPlayer(player);
        }

        System.out.println("First team have " + team.getFirstTeam().size() + " players");
        System.out.println("Reserve team have " + team.getReserveTeam().size() + " players");

    }
}
