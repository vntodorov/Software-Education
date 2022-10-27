package GenericsEXERCISES.GenericSwapMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<String> box = new Box<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            box.add(name);
        }
        String[] indexes = scanner.nextLine().split("\\s+");

        int indexOfFirst = Integer.parseInt(indexes[0]);
        int indexOfSecond = Integer.parseInt(indexes[1]);

        box.swap(indexOfFirst, indexOfSecond);

        System.out.println(box);


    }
}
