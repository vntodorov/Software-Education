package BasicSyntaxEXERCISE;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalMoney = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double lightsabersPrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltsPrice = Double.parseDouble(scanner.nextLine());
        double totalLightsabersPrice = Math.ceil((students + students * 10 / 100.00)) * lightsabersPrice;
        double totalRobePrice = students * robePrice;
        double totalBeltsPrice = (students - students / 6) * beltsPrice;
        double total = totalLightsabersPrice + totalRobePrice + totalBeltsPrice;
        if (totalMoney >= total) {
            System.out.printf("The money is enough - it would cost %.2flv.", total);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", total - totalMoney);
        }
    }
}
