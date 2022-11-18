package EncapsulationEXERCISES.FootballTeamGenerator;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        HashMap<String, Team> teams = new HashMap<>();

        while (!command.equals("END")) {
            String[] data = command.split("\\;");
            String currentCommand = data[0];
            String currentTeamName = data[1];

            switch (currentCommand) {
                case "Team":

                    try {
                        Team team = new Team(currentTeamName);
                        teams.put(team.getName(), team);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "Add":
                    if (!teams.containsKey(currentTeamName)) {
                        System.out.println("Team " + currentTeamName + " does not exist.");
                        break;
                    }

                    try {
                        Player player = new Player
                                (data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7]));
                        teams.get(currentTeamName).addPlayer(player);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "Remove":
                    String playerName = data[2];

                    try {
                        teams.get(currentTeamName).removePlayer(playerName);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "Rating":
                    if (!teams.containsKey(currentTeamName)) {
                        System.out.println("Team " + currentTeamName + " does not exist.");
                        break;
                    }

                    System.out.println(teams.get(currentTeamName));

                    break;
            }

            command = scanner.nextLine();
        }
    }
}
