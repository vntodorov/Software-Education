package FinalExamEXERCISE;

import java.util.*;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pieces = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> piecesCollection = new LinkedHashMap<>();
        for (int i = 1; i <= pieces ; i++) {
            String[] elements = scanner.nextLine().split("\\|");
            String currentPiece = elements[0];
            String currentComposer = elements[1];
            String currentKey = elements[2];
            List<String> piecesInfoList = new ArrayList<>();
            piecesInfoList.add(currentComposer);
            piecesInfoList.add(currentKey);
            piecesCollection.put(currentPiece, piecesInfoList);
        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")){
            String currentCommand = command.split("\\|")[0];
            String currentPiece = command.split("\\|")[1];
            switch (currentCommand){
                case "Add":
                    if (!piecesCollection.containsKey(currentPiece)){
                        String addComposer = command.split("\\|")[2];
                        String addKey = command.split("\\|")[3];
                        List<String> currentInfo = new ArrayList<>();
                        currentInfo.add(addComposer);
                        currentInfo.add(addKey);
                        piecesCollection.put(currentPiece, currentInfo);
                        System.out.printf("%s by %s in %s added to the collection!%n", currentPiece, addComposer, addKey);
                    } else {
                        System.out.printf("%s is already in the collection!%n", currentPiece);
                    }
                    break;
                case "Remove":
                    if (piecesCollection.containsKey(currentPiece)){
                        piecesCollection.remove(currentPiece);
                        System.out.printf("Successfully removed %s!%n", currentPiece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", currentPiece);
                    }
                    break;
                case "ChangeKey":
                    if (piecesCollection.containsKey(currentPiece)){
                        String newKey = command.split("\\|")[2];
                        piecesCollection.get(currentPiece).set(1, newKey);
                        System.out.printf("Changed the key of %s to %s!%n", currentPiece, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", currentPiece);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        piecesCollection.entrySet().forEach(piece -> System.out.printf("%s -> Composer: %s, Key: %s%n", piece.getKey(), piece.getValue().get(0), piece.getValue().get(1)));
    }
}
