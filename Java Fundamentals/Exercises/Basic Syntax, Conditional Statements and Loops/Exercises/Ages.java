package BasicSyntaxEXERCISE;

import java.util.Scanner;

public class Ages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = Integer.parseInt(scanner.nextLine());
        String result = "";
        if (age <= 2){
            result = "baby";
        } else if (age <= 13){
            result = "child";
        } else if (age <= 19){
            result = "teenager";
        } else if (age <= 65){
            result = "adult";
        } else {
            result = "elder";
        }
        System.out.println(result);
    }
}
