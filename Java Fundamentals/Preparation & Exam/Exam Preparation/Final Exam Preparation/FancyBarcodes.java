package FinalExamEXERCISE;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        Pattern barcode = Pattern.compile("^@[#]+[A-Z][A-Za-z0-9]{4,}[A-Z]@[#]+$");
        Pattern numbers = Pattern.compile("\\d");
        for (int i = 1; i <= lines ; i++) {
            String input = scanner.nextLine();
            Matcher barcodeMatcher = barcode.matcher(input);
            if (barcodeMatcher.find()){
                String productGroup = "00";
                StringBuilder groupBuilder = new StringBuilder();
                Matcher numbersMatcher = numbers.matcher(input);
                while (numbersMatcher.find()){
                    groupBuilder.append(numbersMatcher.group());
                }
                if (!groupBuilder.toString().isEmpty()){
                    productGroup = groupBuilder.toString();
                }
                System.out.printf("Product group: %s%n", productGroup);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}