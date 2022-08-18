package ListEXERCISE;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> stringList = Arrays
                .stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("3:1")){
            String currentCommand = command.split(" ")[0];
            switch (currentCommand){
                case "merge":
                    int startIndex = Integer.parseInt(command.split(" ")[1]);
                    int endIndex = Integer.parseInt(command.split(" ")[2]);
                    if (startIndex < 0){
                        startIndex = 0;
                    }
                    if (endIndex > stringList.size() - 1){
                        endIndex = stringList.size() - 1;
                    }
                    boolean isValidIndexes = startIndex <= stringList.size() - 1 && endIndex >= 0 && startIndex < endIndex;
                    if (isValidIndexes){
                        String resultMerge = "";
                        for (int i = startIndex; i <= endIndex ; i++) {
                            String currentString = stringList.get(startIndex);
                            resultMerge += currentString;
                            stringList.remove(startIndex);
                        }
                        stringList.add(startIndex, resultMerge);
                    }
                    break;
                case "divide":
                    int index = Integer.parseInt(command.split(" ")[1]);
                    int partitions = Integer.parseInt(command.split(" ")[2]);
                    String elementForDivide = stringList.get(index);
                    stringList.remove(index);
                    int partSize = elementForDivide.length() / partitions;
                    int beginIndexOfText = 0;
                    for (int i = 1; i < partitions ; i++) {
                        stringList.add(index, elementForDivide.substring(beginIndexOfText, beginIndexOfText + partSize));
                        index++;
                        beginIndexOfText += partSize;
                    }
                    stringList.add(index, elementForDivide.substring(beginIndexOfText));
                    break;
            }
            command = scanner.nextLine();
        }
        for (String name : stringList){
            System.out.print(name + " ");
        }
    }
}
