package SetsAndMapsAdvancedLAB;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String guest = scanner.nextLine();

        Set<String> vipGuests = new TreeSet<>();
        Set<String> regularGuests = new TreeSet<>();

        while (!guest.equals("PARTY")) {
            if (guest.length() == 8) {

                if (Character.isDigit(guest.charAt(0))) {
                    vipGuests.add(guest);
                } else {
                    regularGuests.add(guest);
                }

            }
            guest = scanner.nextLine();
        }

        String arriveGuest = scanner.nextLine();

        while (!arriveGuest.equals("END")) {
            vipGuests.remove(arriveGuest);
            regularGuests.remove(arriveGuest);


            arriveGuest = scanner.nextLine();
        }

        System.out.println(regularGuests.size() + vipGuests.size());

        if (vipGuests.size() > 0) {
            System.out.println(String.join(System.lineSeparator(), vipGuests));
        }
        if (regularGuests.size() > 0) {
            System.out.println(String.join(System.lineSeparator(), regularGuests));
        }
    }
}
