package TextProcessingEXERCISE;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("[\\\\:.]+");
        String fileName = input[input.length - 2];
        String extension = input[input.length - 1];
        System.out.printf("File name: %s%nFile extension: %s", fileName, extension);
    }
}
