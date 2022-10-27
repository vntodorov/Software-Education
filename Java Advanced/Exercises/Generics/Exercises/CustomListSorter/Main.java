package GenericsEXERCISES.CustomListSorter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList<String> customList = new CustomList<>();

        String input = scanner.nextLine();

        while (!input.equals("END")){
            String currentCommand = input.split("\\s+")[0];

            switch (currentCommand){
                case "Add":
                    String currentAddWord = input.split("\\s+")[1];
                    customList.add(currentAddWord);
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(input.split("\\s+")[1]);
                    customList.remove(indexToRemove);
                    break;
                case "Contains":
                    String currentContainsWord = input.split("\\s+")[1];
                    System.out.println(customList.contains(currentContainsWord));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(input.split("\\s+")[1]);
                    int secondIndex = Integer.parseInt(input.split("\\s+")[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String currentCompareWord = input.split("\\s+")[1];
                    System.out.println(customList.countGreaterThan(currentCompareWord));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
                case "Print":
                    System.out.println(customList);
                    break;
            }
            input = scanner.nextLine();
        }



    }
}
