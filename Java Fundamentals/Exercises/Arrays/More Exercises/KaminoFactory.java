package Arrays;

import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxSum = 0;
        int bestIndex = Integer.MAX_VALUE;
        int dnaCount = 0;
        int bestDnaCount = 0;
        int length = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        String[] bestDNA = new String[length];
        while (!input.equals("Clone them!")) {
            dnaCount++;
            String[] elements = input.split("!+");
            int currentSum = 0;
            boolean maxSumHere = false;
            int currentBestIndex = 0;
            int oneCount = 0;
            for (int i = 0; i < elements.length; i++) {
                int currentDNA = Integer.parseInt(elements[i]);
                if (currentDNA == 1) {
                    oneCount++;
                    if (i - 1 > currentBestIndex && oneCount == 2) {
                        currentBestIndex = i - 1;
                    }
                    currentSum++;
                    if (currentSum > maxSum) {
                        maxSum = currentSum;
                        maxSumHere = true;
                    }
                } else {
                    oneCount = 0;
                }
            }
            if (currentBestIndex < bestIndex){
                bestIndex = currentBestIndex;
                maxSum = currentSum;
                bestDNA = input.split("!+");
                bestDnaCount = dnaCount;
            } else if (currentBestIndex == bestIndex && maxSumHere){
                bestDNA = input.split("!+");
                bestDnaCount = dnaCount;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", bestDnaCount, maxSum);
        for (String dna : bestDNA){
            System.out.print(dna + " ");
        }
    }
}